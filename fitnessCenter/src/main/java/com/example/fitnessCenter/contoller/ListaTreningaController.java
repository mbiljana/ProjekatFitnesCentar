package com.example.fitnessCenter.contoller;

import com.example.fitnessCenter.entity.*;
import com.example.fitnessCenter.entity.DTO.*;
import com.example.fitnessCenter.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/api/termini")
public class ListaTreningaController {

    private final RasporedTreningaService rasporedTreningaService;
    private final OcenaTreningaService ocenaTreningaService;
    private final ClanService clanService;
    private final TrenerService trenerService;
    private final TreningService treningService;
    @Autowired
    public ListaTreningaController(RasporedTreningaService rasporedTreningaService, TrenerService trenerService,
                            OcenaTreningaService ocenaTreningaService, ClanService clanService,
                            TreningService treningService) {
        this.rasporedTreningaService = rasporedTreningaService;
        this.ocenaTreningaService = ocenaTreningaService;
        this.clanService = clanService;
        this.trenerService = trenerService;
        this.treningService = treningService;
    }

    @PostMapping(
            value = ("/rezervacija"),
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<RezervacijaDTO> rezervisi (@RequestBody RezervacijaDTO info) throws Exception{

        ListaTreninga listaTreninga = this.rasporedTreningaService.findOne(info.getIdTermina());
        if((listaTreninga.getSala().getKapacitet() - listaTreninga.getPrijavljeniClanovi().size()) < 1) {

            throw new Exception("Nema slobodnih mesta za trazeni termin!");
        }
        else{
            Clan clan = clanService.findOne(info.getIdKorisnika());
            listaTreninga.getPrijavljeniClanovi().add(clan);
            listaTreninga.setBrojPrijavljenih(listaTreninga.getBrojPrijavljenih()+1);
            rasporedTreningaService.update(listaTreninga);
            clan.getPrijavljeniTreninzi().add(listaTreninga);
            clanService.update(clan);

        }
        return new ResponseEntity<>(info, HttpStatus.OK);
    }

    @PostMapping(
            value = ("/otkazivanjeTermina"),
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<RezervacijaDTO> otkazi (@RequestBody RezervacijaDTO info) throws Exception{

        ListaTreninga listaTreninga = this.rasporedTreningaService.findOne(info.getIdTermina());

        Clan clan = clanService.findOne(info.getIdKorisnika());
        listaTreninga.getPrijavljeniClanovi().remove(clan);
        listaTreninga.setBrojPrijavljenih(listaTreninga.getBrojPrijavljenih()-1);
        rasporedTreningaService.update(listaTreninga);
        clan.getPrijavljeniTreninzi().remove(listaTreninga);
        clanService.update(clan);
        return new ResponseEntity<>(info, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ListaTreningaDTO> getTermin(@PathVariable("id") Long id)
    {
        ListaTreninga listaTreninga = this.rasporedTreningaService.findOne(id);
        ListaTreningaDTO trazeniTermin = new ListaTreningaDTO();
        trazeniTermin.setId(listaTreninga.getId());
        trazeniTermin.setBrojClanova(listaTreninga.getBrojPrijavljenih());
        trazeniTermin.setCena(listaTreninga.getCena());
        trazeniTermin.setDatumKraja(listaTreninga.getDatumKrajaTreninga());
        trazeniTermin.setDatumPocetka(listaTreninga.getDatumPocetkaTreninga());
        trazeniTermin.setFitnessCentar(listaTreninga.getFitnessCentar());
        trazeniTermin.setTrening(listaTreninga.getTrening());
        trazeniTermin.setSala(listaTreninga.getSala());
        return new ResponseEntity<>(trazeniTermin, HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ListaTreningaDTO>> getTermini() {
        List<ListaTreninga> termini = this.rasporedTreningaService.findAll();

        List<ListaTreningaDTO> trazeniTermini = new ArrayList<>();

        for(ListaTreninga t : termini) {
            ListaTreningaDTO termin = new ListaTreningaDTO(t.getId(), t.getCena(), t.getDatumPocetkaTreninga(), t.getDatumKrajaTreninga(), t.getBrojPrijavljenih(),
                    t.getTrening(), t.getSala(), t.getFitnessCentar());
            trazeniTermini.add(termin);
        }
        return new ResponseEntity<>(trazeniTermini, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteTermin(@PathVariable Long id) {
        this.rasporedTreningaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PostMapping(value = ("/odradjeniTreninzi"),
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<OdradjeniTreninziDTO>> odradjeniTreninzi(@RequestBody TreninziKorisnikaDTO info) {
        Clan clan = clanService.findOne(info.getIdKorisnika());
        List<OdradjeniTreninziDTO> ret = new ArrayList<>();
        for(ListaTreninga t: clan.getOdradjeniTreninzi()) {
            OdradjeniTreninziDTO odr = new OdradjeniTreninziDTO();
            odr.setIdt(t.getId());
            odr.setNaziv(t.getTrening().getNaziv());
            odr.setCena(t.getCena());
            odr.setTrajanje(t.getTrening().getTrajanje());
            odr.setDatumPocetka(t.getDatumPocetkaTreninga());
            odr.setTipTreninga(t.getTrening().getTipTreninga());
            odr.setImeTrenera(t.getTrening().getTrener().getIme());
            float suma = 0;
            for(OcenaTreninga o : t.getOcenaTreningas()) {
                suma += o.getOcena();
            }
            if(suma == 0) {
                odr.setProsecnaOcena(0);
            }
            else
                odr.setProsecnaOcena(suma / t.getOcenaTreningas().size());
            odr.setNazivFitnesCentra(t.getFitnessCentar().getNazivCentra());
            odr.setNazivSale(t.getSala().getOznaka());
            odr.setOdgovara(true);
            ret.add(odr);
        }
        return new ResponseEntity<>(ret, HttpStatus.OK);
    }

    @PostMapping(value = ("/neocenjeni"),
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<OdradjeniTreninziDTO>> neocenjeniTreninzi(@RequestBody TreninziKorisnikaDTO info) throws Exception {
        Clan clan = clanService.findOne(info.getIdKorisnika());
        List<OdradjeniTreninziDTO> ret = new ArrayList<>();
        int oznaka = 0;
        for(ListaTreninga t: clan.getOdradjeniTreninzi()) {
            for(OcenaTreninga o : t.getOcenaTreningas()) {
                if(o.getClan().getId() == clan.getId()) {
                    oznaka++;
                }

            }
            if(oznaka == 0) {
                OdradjeniTreninziDTO odr = new OdradjeniTreninziDTO();
                odr.setIdt(t.getId());
                odr.setNaziv(t.getTrening().getNaziv());
                odr.setCena(t.getCena());
                odr.setTrajanje(t.getTrening().getTrajanje());
                odr.setDatumPocetka(t.getDatumPocetkaTreninga());
                odr.setTipTreninga(t.getTrening().getTipTreninga());
                odr.setImeTrenera(t.getTrening().getTrener().getIme());
                float suma = 0;
                for(OcenaTreninga oc : t.getOcenaTreningas()) {
                    suma += oc.getOcena();
                }
                if(suma == 0) {
                    odr.setProsecnaOcena(0);
                }
                else
                    odr.setProsecnaOcena(suma / t.getOcenaTreningas().size());
                odr.setNazivFitnesCentra(t.getFitnessCentar().getNazivCentra());
                odr.setNazivSale(t.getSala().getOznaka());
                odr.setOdgovara(true);
                ret.add(odr);
                oznaka = 0;
            }

        }
        return new ResponseEntity<>(ret, HttpStatus.OK);
    }




    @PostMapping(value = ("/ocenjeni"),
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<OcenjeniTreninziDTO>> ocenjeniTreninzi(@RequestBody TreninziKorisnikaDTO info) throws Exception {
        Clan clan = clanService.findOne(info.getIdKorisnika());
        List<OcenjeniTreninziDTO> ret = new ArrayList<>();
        int oznaka = 0;
        for(ListaTreninga t: clan.getOdradjeniTreninzi()) {
            for(OcenaTreninga o : t.getOcenaTreningas()) {
                if(o.getClan().getId() == clan.getId()) {
                    OcenjeniTreninziDTO odr = new OcenjeniTreninziDTO();
                    odr.setIdt(t.getId());
                    odr.setNaziv(t.getTrening().getNaziv());
                    odr.setCena(t.getCena());
                    odr.setTrajanje(t.getTrening().getTrajanje());
                    odr.setDatumPocetka(t.getDatumPocetkaTreninga());
                    odr.setTipTreninga(t.getTrening().getTipTreninga());
                    odr.setImeTrenera(t.getTrening().getTrener().getIme());
                    float suma = 0;
                    for(OcenaTreninga oc : t.getOcenaTreningas()) {
                        suma += oc.getOcena();
                    }
                    if(suma == 0) {
                        odr.setProsecnaOcena(0);
                    }
                    else
                        odr.setProsecnaOcena(suma / t.getOcenaTreningas().size());
                    odr.setNazivFitnesCentra(t.getFitnessCentar().getNazivCentra());
                    odr.setNazivSale(t.getSala().getOznaka());
                    odr.setOdgovara(true);
                    odr.setOcenaKorisnika(o.getOcena());
                    ret.add(odr);
                }

            }
        }
        return new ResponseEntity<>(ret, HttpStatus.OK);
    }



    @PostMapping(value = ("/kreiranje"),
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ListaTreninga> kreiranje(@RequestBody KreiranjeTerminaDTO kDTO) throws Exception {
        Trener trener =  trenerService.findOne(kDTO.getKorisnik());
        Trening trening = treningService.findOne(kDTO.getTrening());
        ListaTreninga noviTermin = new ListaTreninga(kDTO.getCena(), kDTO.getDatumPocetka(), trening,
                trener.getFitnessCentar());
        ListaTreninga t = rasporedTreningaService.save(noviTermin);

        return new ResponseEntity<>(noviTermin, HttpStatus.CREATED);

    }


    @PostMapping(value = ("/izmena"),
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> izmena(@RequestBody IzmenaTerminaDTO kDTO) throws Exception {
        Trener trener =  trenerService.findOne(kDTO.getIdKorisnika());

        for(Trening t : trener.getListaTreninga()){
            for(ListaTreninga ter : t.getTerminiTreninga()) {
                if(ter.getId() == kDTO.getIdTermina()) {
                    ter.setCena(kDTO.getCena());
                    ter.setDatumPocetkaTreninga(kDTO.getDatumPocetka());
                    rasporedTreningaService.update(ter);
                }
            }
        }

        return new ResponseEntity<>(HttpStatus.OK);

    }




    @PostMapping(value = ("/rezervisaniTreninzi"), consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FiltriraniTreninziDTO>> createUser(@RequestBody TreninziKorisnikaDTO kDTO) throws Exception {
        Clan korisnik =  clanService.findOne(kDTO.getIdKorisnika());
        List<FiltriraniTreninziDTO> ret = new ArrayList<>();
        for(ListaTreninga t : korisnik.getPrijavljeniTreninzi()) {
            FiltriraniTreninziDTO filtrirani = new FiltriraniTreninziDTO();
            filtrirani.setIdt(t.getId());
            filtrirani.setNaziv(t.getTrening().getNaziv());
            filtrirani.setCena(t.getCena());
            filtrirani.setTrajanje(t.getTrening().getTrajanje());
            filtrirani.setDatumPocetka(t.getDatumPocetkaTreninga());
            filtrirani.setDatumKraja(t.getDatumKrajaTreninga());
            filtrirani.setImeTrenera(t.getTrening().getTrener().getIme());
            filtrirani.setTipTreninga(t.getTrening().getTipTreninga());
            filtrirani.setNazivFitnesCentra(t.getFitnessCentar().getNazivCentra());
            filtrirani.setNazivSale(t.getSala().getOznaka());

            filtrirani.getProsecnaOcena();
            filtrirani.getPreostalaMesta();
            ret.add(filtrirani);
        }
        return new ResponseEntity<>(ret, HttpStatus.CREATED);

    }

    @PostMapping(
            value = ("/pretraga"),
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<FiltriraniTreninziDTO>> traziTermine(@RequestBody PretragaDTO info) throws Exception{
        List<FiltriraniTreninziDTO> ret = new ArrayList<>();
        for(ListaTreninga t: this.rasporedTreningaService.findAll()) {

            FiltriraniTreninziDTO filtrirani = new FiltriraniTreninziDTO();
            filtrirani.setIdt(t.getId());
            filtrirani.setNaziv(t.getTrening().getNaziv());
            filtrirani.setCena(t.getCena());
            filtrirani.setTrajanje(t.getTrening().getTrajanje());
            filtrirani.setDatumPocetka(t.getDatumPocetkaTreninga());
            filtrirani.setDatumKraja(t.getDatumKrajaTreninga());
            filtrirani.setImeTrenera(t.getTrening().getTrener().getIme());
            filtrirani.setTipTreninga(t.getTrening().getTipTreninga());
            filtrirani.setNazivFitnesCentra(t.getFitnessCentar().getNazivCentra());
            filtrirani.setNazivSale(t.getSala().getOznaka());
            float ocenaSrednja = 0;
            int delioc = 0;
            for(OcenaTreninga ocena : this.ocenaTreningaService.getByTreningId(t.getTrening().getId())) {
                if(ocena.getOcena() >0) {
                    ocenaSrednja += ocena.getOcena();
                    delioc++;
                }
            }
            if(delioc ==0 ){
                ocenaSrednja =0;
            }
            else{
                ocenaSrednja /= delioc;
            }
            filtrirani.setProsecnaOcena(ocenaSrednja);
            filtrirani.setPreostalaMesta(t.getSala().getKapacitet() - t.getBrojPrijavljenih());
            filtrirani.setOdgovara(true);


            ret.add(filtrirani);

            for(FiltriraniTreninziDTO trening : ret) {
                System.out.println(trening + "\n");
            }

            if(info.getNaziv() != null)
                for(FiltriraniTreninziDTO pp : ret)
                    if(!pp.getNaziv().contains(info.getNaziv()))
                        pp.setOdgovara(false);
            if(info.getCena() != 0)
                for(FiltriraniTreninziDTO pp : ret)
                    if(pp.getCena() > info.getCena())
                        pp.setOdgovara(false);
            if(info.getTrajanje() != 0)
                for(FiltriraniTreninziDTO pp : ret)
                    if(pp.getTrajanje() > info.getTrajanje())
                        pp.setOdgovara(false);
            if(info.getDatumPocetka() != null)
                for(FiltriraniTreninziDTO pp : ret)
                    if(info.getDatumPocetka().after(pp.getDatumPocetka()))
                        pp.setOdgovara(false);


        }
        List<FiltriraniTreninziDTO> zasortiranje = new ArrayList<>();
        for(FiltriraniTreninziDTO pp : ret)
            if(pp.isOdgovara())
                zasortiranje.add(pp);
        for(FiltriraniTreninziDTO trening : zasortiranje) {
            System.out.println(trening + "\n");
        }

        switch (info.getTipSortiranja()) {
            case 1:
                for(int i = 0; i < zasortiranje.size(); i++) {
                    for(int j = i; j < zasortiranje.size(); j++) {
                        if(zasortiranje.get(i).getNaziv().compareTo(zasortiranje.get(j).getNaziv()) > 0) {
                            FiltriraniTreninziDTO pom = new FiltriraniTreninziDTO();
                            pom.zameni(zasortiranje.get(i));
                            zasortiranje.get(i).zameni(zasortiranje.get(j));
                            zasortiranje.get(j).zameni(pom);
                        }

                    }
                }
                break;

            case 2:
                for(int i = 0; i < zasortiranje.size(); i++) {
                    for(int j = i; j < zasortiranje.size(); j++) {
                        if(zasortiranje.get(i).getTrajanje() > zasortiranje.get(j).getTrajanje()){
                            FiltriraniTreninziDTO pom = new FiltriraniTreninziDTO();
                            pom.zameni(zasortiranje.get(i));
                            zasortiranje.get(i).zameni(zasortiranje.get(j));
                            zasortiranje.get(j).zameni(pom);
                        }
                    }
                }
                break;

            case 3:


                for(int i = 0; i < zasortiranje.size(); i++) {
                    for(int j = i; j < zasortiranje.size(); j++) {
                        if(zasortiranje.get(i).getCena() > zasortiranje.get(j).getCena()) {
                            FiltriraniTreninziDTO pom = new FiltriraniTreninziDTO();
                            pom.zameni(zasortiranje.get(i));
                            zasortiranje.get(i).zameni(zasortiranje.get(j));
                            zasortiranje.get(j).zameni(pom);
                        }
                    }
                }
                break;
            case 4:

                for(int i = 0; i < zasortiranje.size(); i++) {
                    for(int j = i; j < zasortiranje.size(); j++) {
                        if(zasortiranje.get(i).getDatumPocetka().after(zasortiranje.get(j).getDatumPocetka())) {
                            FiltriraniTreninziDTO pom = new FiltriraniTreninziDTO();
                            pom.zameni(zasortiranje.get(i));
                            zasortiranje.get(i).zameni(zasortiranje.get(j));
                            zasortiranje.get(j).zameni(pom);
                        }
                    }
                }
                break;

            case 5:

                for(int i = 0; i < zasortiranje.size(); i++) {
                    for(int j = i; j < zasortiranje.size(); j++) {
                        if(zasortiranje.get(i).getProsecnaOcena() > zasortiranje.get(j).getProsecnaOcena()) {
                            FiltriraniTreninziDTO pom = new FiltriraniTreninziDTO();
                            pom.zameni(zasortiranje.get(i));
                            zasortiranje.get(i).zameni(zasortiranje.get(j));
                            zasortiranje.get(j).zameni(pom);
                        }
                    }
                }
                break;
        }


        return new ResponseEntity<>(zasortiranje, HttpStatus.OK);
    }


}
