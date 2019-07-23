package br.ouriques.Application.web;

import br.ouriques.Application.domain.Message;
import br.ouriques.Application.service.MessageBrokerService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/processor")
public class BulkingController {

    @Autowired
    private MessageBrokerService messageBrokerService;

    @Autowired
    private Gson gson;

    @PostMapping
    public ResponseEntity<Object> post(@RequestBody Message message) {
        messageBrokerService.send(gson.toJson(message));
        return ResponseEntity.ok().build();
    }

}
