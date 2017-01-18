package com.example.myalexa

import com.amazon.speech.speechlet.*
import org.slf4j.LoggerFactory

class MainSpeechlet : Speechlet {

    private val logger = LoggerFactory.getLogger(MainSpeechlet::class.java)

    override fun onSessionStarted(request: SessionStartedRequest, session: Session) {
        logger.info("onSessionStarted: request=$request session=$session")
    }

    override fun onLaunch(request: LaunchRequest, session: Session): SpeechletResponse {
        logger.info("onLaunch: request=$request session=$session")

        return Speeches.welcomeResponse
    }

    override fun onIntent(request: IntentRequest, session: Session): SpeechletResponse {
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

    override fun onSessionEnded(request: SessionEndedRequest, session: Session) {
        logger.info("onSessionEnded: request=$request session=$session")
    }
}