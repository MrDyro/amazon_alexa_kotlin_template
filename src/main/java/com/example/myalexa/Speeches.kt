package com.example.myalexa

import com.amazon.speech.speechlet.SpeechletResponse
import com.amazon.speech.ui.PlainTextOutputSpeech
import com.amazon.speech.ui.Reprompt


object Speeches {
    val welcomeResponse: SpeechletResponse = kotlin.run {
        val speechText = "Hallo und herzlich willkommen."

        val speech = PlainTextOutputSpeech().apply {
            text = speechText
        }

        val reprompt = Reprompt().apply {
            outputSpeech = speech
        }

        SpeechletResponse.newAskResponse(speech, reprompt)
    }

    val helpResponse: SpeechletResponse = kotlin.run {
        val speech = PlainTextOutputSpeech().apply {
            text = "Sagen Sie doch einfach mal Hallo."
        }

        val reprompt = Reprompt().apply {
            outputSpeech = speech
        }

        SpeechletResponse.newAskResponse(speech, reprompt)
    }

    val halloWorldResponse: SpeechletResponse = kotlin.run {
        val speech = PlainTextOutputSpeech().apply {
            text = "Hallo Welt! Ich grüße Sie!"
        }

        val reprompt = Reprompt().apply {
            outputSpeech = speech
        }

        SpeechletResponse.newAskResponse(speech, reprompt)
    }

    val stopResponse: SpeechletResponse = kotlin.run {
        val speech = PlainTextOutputSpeech().apply {
            text = "Danke das ich Ihnen dienen durfte!"
        }

        SpeechletResponse.newTellResponse(speech)
    }
}