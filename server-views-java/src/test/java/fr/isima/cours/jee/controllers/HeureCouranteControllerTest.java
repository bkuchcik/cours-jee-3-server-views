package fr.isima.cours.jee.controllers;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;

@RunWith(MockitoJUnitRunner.class)
public class HeureCouranteControllerTest {

    private HeureController heureController = new HeureController();

    @Test
    public void heureCourante_AddHeureCouranteToRequest() throws ParseException {
        final Date now = new Date();

        final ModelAndView modelAndView = this.heureController.heure();

        final Date date = DateUtils
                .parseDate(modelAndView.getModel().get("currentDateAsString").toString(), HeureController.HH_MM_SS_LE_DD_MM_YYYY);
        assertThat(date).isBetween(DateUtils.addSeconds(now, -1), DateUtils.addSeconds(now, 1));
        assertThat(modelAndView.getViewName()).isEqualTo("heureCourante-v5");
    }
}
