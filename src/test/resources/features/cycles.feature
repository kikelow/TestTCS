#laguage: en

  Feature: Cuestionario por ciclos

    Scenario: Responder cuestionario

      Given "Harinson" quiere acceder a el test de ciclos del portal evalart
      And ingresa su usuario y clave y realiza click sobre el boton enviar para acceder
      When responda y envie el cuestionario hasta completar los ciclos
      Then obtendra el hash para validar el examen


