package com.ladykoala.banker.service;

import com.ladykoala.banker.dao.AccountDao;
import com.ladykoala.banker.repository.AccountRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Service
public class AccountServiceCorda {

    @Value("${corda.server}")
    private String cordaServer;

    @Value("${corda.walletParty}")
    private String cordaWalletParty;

    @Autowired
    private AccountRepository accountDao;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


    public String linkKYCtoCorda(AccountDao dao){

        JSONObject dto = new JSONObject();
        try {
            dto.put("accountId" , dao.getId());
            dto.put("lastname", dao.getLastname());
            dto.put("firstname",dao.getFirstname());
            dto.put("middlename", dao.getMiddlename());
            if(dao.getBirthday()!=null){
                DateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
                String strDate = dateFormat.format(dao.getBirthday());
                dto.put("birthday", strDate);
            }
            dto.put("permanentAddress", dao.getPermanentAddress());
            dto.put("currentAddress", dao.getAddress());
            dto.put("fathername", dao.getFatherName());
            dto.put("mothername", dao.getMotherName());
            dto.put("gender", dao.getGender());
            dto.put("contactNo", dao.getContactNo());
            dto.put("maritalStatus", dao.getMaritalStatus());
            dto.put("nationality", dao.getNationality());
            dto.put("occupation", dao.getOccupation());
            dto.put("income", dao.getGrossIncome());

            JSONObject otherParty = new JSONObject();
            otherParty.put("name", cordaWalletParty);
            dto.put("otherParty", otherParty);

            JSONObject options = new JSONObject();
            options.put("trackProgress", true);
            dto.put("options", options);

            String url = cordaServer + "/node/Cordapp-example Flows/KYCRequestInitiator";

            HttpEntity<?> requestHttp = new HttpEntity(dto.toString());
            ResponseEntity<String> linkResult = restTemplate().exchange(url,  HttpMethod.POST,requestHttp, String.class);
            String cordaRes = linkResult.getBody();
            if (linkResult.getStatusCode() == HttpStatus.ACCEPTED ||
                    linkResult.getStatusCode() == HttpStatus.OK ){
                String location = linkResult.getHeaders().get("Location").get(0);
                int idx = location.lastIndexOf("/")+1;
                return location.substring(idx);
            }else{
                return null;
            }

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }
}
