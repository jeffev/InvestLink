package com.bezkoder.spring.jpa.postgresql.service;

import com.bezkoder.spring.jpa.postgresql.model.Acao;
import com.bezkoder.spring.jpa.postgresql.model.Usuario;
import com.bezkoder.spring.jpa.postgresql.repository.AcaoRepository;
import com.bezkoder.spring.jpa.postgresql.resources.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.Comparator;
import java.util.List;

@Service
public class AcaoService {
    @Autowired
    private AcaoRepository acaoRepository;

    public List<Acao> findAll() {
        return acaoRepository.findAll();
    }

    public List<Acao> findAllFormulaMagica() {
        List<Acao> acoes = acaoRepository.findAll();
        int count = 0;

        String login = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Acao> acoesFavoritasUsuario = acaoRepository.findAcoesFavoritasByUsuarioId(login);

        acoes.sort(Comparator.comparing(Acao::getRoe).reversed());
        for (Acao acao: acoes) {
            if (acoesFavoritasUsuario.contains(acao)) {
                acao.setFavorita(true);
            } else {
                acao.setFavorita(false);
            }

            count += 1;
            acao.setRankRoe(count);
        }

        count = 0;
        acoes.sort(Comparator.comparing(Acao::getPl));
        for (Acao acao: acoes) {
            count += 1;
            acao.setRankPl(count);
        }

        return acoes;
    }

    public void atualizarAcoes(MultipartFile file) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
        String line = reader.readLine(); // lê a primeira linha e descarta

        acaoRepository.deleteAll();

        while ((line = reader.readLine()) != null) {
            String[] fields = line.split(";");

            Acao acao = new Acao();
            acao.setTicker(fields[0]);
            acao.setPreco(Utils.stringToBiGDecimal(fields[1]));
            acao.setDy(Utils.stringToBiGDecimal(fields[2]));
            acao.setPl(Utils.stringToBiGDecimal(fields[3]));
            acao.setPvp(Utils.stringToBiGDecimal(fields[4]));
            acao.setpAtivos(Utils.stringToBiGDecimal(fields[5]));
            acao.setMargemBruta(Utils.stringToBiGDecimal(fields[6]));
            acao.setMargemEbit(Utils.stringToBiGDecimal(fields[7]));
            acao.setMargemLiquida(Utils.stringToBiGDecimal(fields[8]));
            acao.setpEbit(Utils.stringToBiGDecimal(fields[9]));
            acao.setEvEbit(Utils.stringToBiGDecimal(fields[10]));
            acao.setDividaLiquidaEbit(Utils.stringToBiGDecimal(fields[11]));
            acao.setDividaLiquidaPatri(Utils.stringToBiGDecimal(fields[12]));
            acao.setPsr(Utils.stringToBiGDecimal(fields[13]));
            acao.setpCapGiro(Utils.stringToBiGDecimal(fields[14]));
            acao.setpAtivoCircLiq(Utils.stringToBiGDecimal(fields[15]));
            acao.setLiqCorrente(Utils.stringToBiGDecimal(fields[16]));
            acao.setRoe(Utils.stringToBiGDecimal(fields[17]));
            acao.setRoa(Utils.stringToBiGDecimal(fields[18]));
            acao.setRoic(Utils.stringToBiGDecimal(fields[19]));
            acao.setPatrimonioAtivos(Utils.stringToBiGDecimal(fields[20]));
            acao.setPassivoAtivos(Utils.stringToBiGDecimal(fields[21]));
            acao.setGiroAtivos(Utils.stringToBiGDecimal(fields[22]));
            acao.setCagrReceita5Anos(Utils.stringToBiGDecimal(fields[23]));
            acao.setCagrLucros5Anos(Utils.stringToBiGDecimal(fields[24]));
            acao.setLiquidez(Utils.stringToBiGDecimal(fields[25]));
            acao.setVpa(Utils.stringToBiGDecimal(fields[26]));
            acao.setLpa(Utils.stringToBiGDecimal(fields[27]));
            acao.setPegRatio(Utils.stringToBiGDecimal(fields[28]));
            if (fields.length == 30) acao.setValorMercado(Utils.stringToBiGDecimal(fields[29]));

            System.out.println(acao.getTicker());

            acaoRepository.save(acao);
        }
        reader.close();
    }

    public Acao findById(String ticker) {
        return acaoRepository.findByTicker(ticker);
    }

    public Acao save(Acao acao) {
        return acaoRepository.save(acao);
    }

    public void deleteById(String id) {
        acaoRepository.deleteById(id);
    }

    public void deleteAll() {
        acaoRepository.deleteAll();
    }
}
