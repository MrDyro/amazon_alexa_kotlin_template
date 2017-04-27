package com.example.myalexa

import com.amazon.speech.json.SpeechletRequestEnvelope
import com.amazon.speech.speechlet.*
import org.slf4j.LoggerFactory

class MainSpeechlet : SpeechletV2 {

    private val logger = LoggerFactory.getLogger(MainSpeechlet::class.java)

    override fun onSessionStarted(requestEnvelope: SpeechletRequestEnvelope<SessionStartedRequest>) {
        val request = requestEnvelope.request
        val session = requestEnvelope.session

        logger.info("onSessionStarted: request=$request session=$session")
    }

    override fun onLaunch(requestEnvelope: SpeechletRequestEnvelope<LaunchRequest>): SpeechletResponse {
        val request = requestEnvelope.request
        val session = requestEnvelope.session

        logger.info("onLaunch: request=$request session=$session")

        return Speeches.welcomeResponse
    }

    override fun onIntent(requestEnvelope: SpeechletRequestEnvelope<IntentRequest>): SpeechletResponse {
        val request = requestEnvelope.request
        val session = requestEnvelope.session

        logger.info("onIntent: request=$request session=$session")

        val intent = request.intent
        val intentName = intent?.name

        return when (intentName) {
            Intents.HALLO_WORLD -> Speeches.halloWorldResponse
            Intents.AMAZON_HELP -> Speeches.helpResponse
            Intents.AMAZON_STOP -> Speeches.stopResponse
            else -> throw SpeechletException("Invalid Intent")
        }
    }

    override fun onSessionEnded(requestEnvelope: SpeechletRequestEnvelope<SessionEndedRequest>) {
        val request = requestEnvelope.request
        val session = requestEnvelope.session

        logger.info("onSessionEnded: request=$request session=$session")
    }
}