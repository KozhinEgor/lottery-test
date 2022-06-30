package com.example.lottery.service;

import com.example.lottery.Repository.ParticipanRepository;
import com.example.lottery.Repository.WinnerRepository;
import com.example.lottery.enity.Participan;
import com.example.lottery.enity.Winner;
import org.apache.catalina.connector.Response;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;


@org.springframework.stereotype.Service
@Transactional
public class Service {
    @Autowired
    public ParticipanRepository participanRepository;
    @Autowired
    public WinnerRepository winnerRepository;

    public List<Participan> allParticipant (){
        return participanRepository.findAll();
    }

    public List<Winner> winner(){
        return winnerRepository.findAll();
    }
    public ResponseEntity participant(Participan participan){
        participanRepository.save(participan);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Winner> lottery() throws Exception {
        if(participanRepository.findAll().size() < 2){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        else{
            Participan participan = participanRepository.findAll().get(random(0,participanRepository.findAll().size()-1));
            participanRepository.deleteAll(participanRepository.findAll());
            return ResponseEntity.ok(winnerRepository.save(new Winner(null, participan.getName(), participan.getAge(), participan.getCity(),random(1,1000))));
        }

    }

    private Integer random(int start, int finish){
        Integer result = null;
        String in = null;
        try {

            org.apache.commons.httpclient.HttpClient client = new HttpClient();

            GetMethod method = new GetMethod("https://www.random.org/integers/?num=1&min="+start+"&max="+finish+"&col=1&base=10&format=plain&rnd=new");

            //Add any parameter if u want to send it with Post req.


            int statusCode = client.executeMethod(method);

            if (statusCode != -1) {
                InputStream str = method.getResponseBodyAsStream();
                in = new String(str.readAllBytes(), StandardCharsets.US_ASCII);

            }

            assert in != null;
            result = Integer.parseInt(in.trim());



        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
