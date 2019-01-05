package fr.isima.cours.jee.controllers

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.BehaviorSpec
import org.apache.commons.lang3.time.DateUtils
import org.assertj.core.api.Assertions.assertThat
import org.springframework.web.servlet.ModelAndView
import java.util.*

class HeureControllerTest : BehaviorSpec({

    given("a valid heure controller") {
        val heureController = HeureController()

        `when`("model and view si generated with default heure method") {

            heureController.heure().apply {
                val now = Date()
                then("date should be now date") {
                    assertThat(parseCurrentDateFromModel()).isBetween(
                            now.addSeconds(-1), now.addSeconds(1))

                }
                then("view name should be heure-courante-v5") {
                    viewName shouldBe "heureCourante-v5"
                }
            }

        }

    }

})

private fun ModelAndView.parseCurrentDateFromModel() = model["currentDateAsString"].toString().parseCurrentDateFromModel()
private fun String.parseCurrentDateFromModel() = DateUtils.parseDate(this, HeureController.HH_MM_SS_LE_DD_MM_YYYY)
private fun Date.addSeconds(numberOfSecond: Int) = DateUtils.addSeconds(this, numberOfSecond)