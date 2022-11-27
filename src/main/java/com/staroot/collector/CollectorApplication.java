package com.staroot.collector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class CollectorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CollectorApplication.class, args);
	}

	private static final Logger log = LoggerFactory.getLogger(CollectorApplication.class);
	
    @GetMapping("/hello")
    public List<Map> hello(){
		log.info("hello");
		Map<String,String> map = new HashMap();
		List<Map> list = new ArrayList<>();
		map.put("user", "user1");
		map.put("email", "user1@gmail.com");
		list.add(map);
		return list;
    }
	@Autowired
    ServerInfoRepository repository;

    @GetMapping("/server/list")
    public List<ServerInfo> serverList(){
        repository.save(new ServerInfo("staroot01","127.0.0.1","uptime","1000d"));
		List<ServerInfo> list = new ArrayList<>();
        for(ServerInfo svrInfo : repository.findAll()){
            log.info(svrInfo.toString());
			list.add(svrInfo);
        }
        log.info(list.toString());
		return list;
    }

	@PostMapping("/server/send")
	public void sendServerInfo(@RequestBody ServerInfo svrInfo){
		log.info(svrInfo.toString());
        repository.save(svrInfo);
	}


}
