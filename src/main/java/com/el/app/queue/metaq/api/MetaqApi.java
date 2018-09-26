package com.el.app.queue.metaq.api;

import com.el.app.queue.metaq.service.MetaqService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Danfeng
 * @since 2018/9/7
 */
@RestController
@AllArgsConstructor
@RequestMapping("app")
public class MetaqApi {

    private final MetaqService metaqService;

    @GetMapping("/metaq")
    public ResponseEntity testMetaq() {
        metaqService.pubMsg();
        return ResponseEntity.ok().build();
    }

}

