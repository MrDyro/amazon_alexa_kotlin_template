package com.example.myalexa

import com.amazon.speech.speechlet.lambda.SpeechletRequestStreamHandler
import java.util.*

/**
 * Add as alexa handler com.example.myalexa.MainSpeechletRequestStreamHandler
 */
class MainSpeechletRequestStreamHandler :
        SpeechletRequestStreamHandler(MainSpeechlet(), HashSet<String>().apply {
            add("amzn1.ask.skill.[your-skill-id]")
        })
