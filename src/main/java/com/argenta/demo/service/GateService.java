package com.argenta.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GateService {

    private final InformationBoardService informationBoardService;

    @Autowired
    public GateService(InformationBoardService informationBoardService) {
        this.informationBoardService = informationBoardService;
    }

    public boolean canEnter() {
        return informationBoardService.hasFreeLot();
    }

    /**
     * Объяснение реализации: в моем понимании осмысленный ответ на этот вопрос ("возможен ли въезд")
     * возможен когда мы знаем положение водителя относительно парковки,
     * т.е. внутри он (значит выъезд всегда возможен)
     * или снаружи (т.е. попытка заехать через выход всегда должна быть невозможной).
     * Не вижу трудности добавить сколь угодно изощренную логику, но кажется задача не требует этого...
     */
    public boolean canExit() {
        return true;
    }
}
