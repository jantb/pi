// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Regular
import compose.icons.fontawesomeicons.regular.*
import engineer.nightowl.sonos.api.SonosApiClient
import engineer.nightowl.sonos.api.SonosApiConfiguration

@Composable
@Preview
fun App() {


    val configuration = SonosApiConfiguration()
    configuration.apiKey = "d36bb705-b104-4c1c-ac19-27b4b3aef2c2"
    configuration.apiSecret = "c57eeb95-77ba-488d-ab72-6c9415b01669"
    configuration.applicationId = "pi"

    val client = SonosApiClient(configuration)
    val stateValue = client.authorize().generateStateValue()
    println(stateValue)
   println( client.authorize().getAuthorizeCodeUri("http://localhost", stateValue))
    val token = client.authorize().createToken("http://localhost", "xn1hWX1W")
    println(token.tokenType)

    client.group().getGroups(token.tokenType, "ho¬me")
    var count = 0
    var text by remember { mutableStateOf("Feiring") }
    var text2 by remember { mutableStateOf("Frustrasjon") }
    var text3 by remember { mutableStateOf("Lunsj") }
    var text4 by remember { mutableStateOf("Lets go nail it!") }
    var text5 by remember { mutableStateOf("Æ e daglig leder!") }
    var text6 by remember { mutableStateOf("Andre artige sitater") }

    MaterialTheme {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize(1f)
        ) {
          Row ( horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()) {
              Button( modifier = Modifier.fillMaxWidth(0.5f), onClick = {
                 // text3 = "Sendt til Sonos"
              }) {
                  Icon(
                      FontAwesomeIcons.Regular.Bell,
                      contentDescription = "Lunsj",
                      modifier = Modifier.size(30.dp)
                  )
                  Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                  Text("Lunsj")
              }

              Button(modifier = Modifier.fillMaxWidth(0.5f), onClick = {
                 // text3 = "Sendt til Sonos"
              }) {
                  Icon(
                      FontAwesomeIcons.Regular.Lemon,
                      contentDescription = "Overtidsmat",
                      modifier = Modifier.size(30.dp)
                  )
                  Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                  Text("Overtidsmat")
              }

          }
            Row ( horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()) {
              Button( modifier = Modifier.fillMaxWidth(0.5f), onClick = {
                 // text3 = "Sendt til Sonos"
              }) {
                  Icon(
                      FontAwesomeIcons.Regular.SmileBeam,
                      contentDescription = "Sertifisering tatt",
                      modifier = Modifier.size(30.dp)
                  )
                  Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                  Text("Sertifisering tatt")
              }
              Button( modifier = Modifier.fillMaxWidth(0.5f),onClick = {
                 // text3 = "Sendt til Sonos"
              }, colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red)) {
                  Icon(
                      FontAwesomeIcons.Regular.Angry,
                      contentDescription = "Lunsj",
                      modifier = Modifier.size(30.dp)
                  )
                  Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                  Text("Jeg er frustrert")
              }

          }
            Row ( horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()) {
              Button( modifier = Modifier.fillMaxWidth(0.5f), onClick = {
                 // text3 = "Sendt til Sonos"
              }) {
                  Icon(
                      FontAwesomeIcons.Regular.SmileWink,
                      contentDescription = "Sertifisering tatt",
                      modifier = Modifier.size(30.dp)
                  )
                  Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                  Text("Ansatt ut i oppdrag")
              }

              Button( modifier = Modifier.fillMaxWidth(0.5f),onClick = {
                 // text3 = "Sendt til Sonos"
              }) {
                  Icon(
                      FontAwesomeIcons.Regular.Grin,
                      contentDescription = "Lunsj",
                      modifier = Modifier.size(30.dp)
                  )
                  Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                  Text("Ny ansatt")
              }

          }
    }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "Marcus sin action app") {
        App()
    }
}
