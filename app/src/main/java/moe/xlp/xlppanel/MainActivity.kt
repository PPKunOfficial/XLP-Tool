package moe.xlp.xlppanel

import android.content.Intent
import android.content.res.Configuration
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import moe.xlp.xlppanel.ui.theme.XLPPanelTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            XLPPanelTheme {

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column {
                        Text(text = "好朋友们:", fontSize = 30.sp, modifier = Modifier.padding(8.dp))
                        AuthorCard(AuthorInformation("PPKun07","那是能让你的孤独无处遁形的晨曦",R.drawable.pp))
                        AuthorCard(AuthorInformation("XPH","人有悲欢离合，月有阴晴圆缺",R.drawable.xph))
                        Button(
                            onClick = {
                                val uri=Uri.parse("http://localhost:11451")
                                val intent=Intent(Intent.ACTION_VIEW,uri)
                                startActivity(intent)

                            },
                            modifier = Modifier.align(
                                alignment = Alignment.CenterHorizontally
                            )
                        ) {
                            Text(text = "跳转到面板")
                        }
                    }
                }
                }
            }
        }
}
data class AuthorInformation(val author:String,val body:String,val Picture:Int)
@Composable
fun AuthorCard(AuthorInf: AuthorInformation){
    Row(modifier = Modifier.padding(8.dp)) {
        Image(
            painter = painterResource(id = AuthorInf.Picture),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
        )
        Spacer(
            modifier = Modifier.width(8.dp)
        )
        Column {
            Text(
                text = AuthorInf.author,
                color = MaterialTheme.colors.secondaryVariant
            )
            Spacer(modifier = Modifier.height(4.dp))
            Surface(shape = MaterialTheme.shapes.medium, elevation = 1.dp) {
                Text(
                    text = AuthorInf.body
                )
            }

        }  
    }


}


@Preview(showBackground = true)
@Preview(name = "Dark Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Light Mode"
)
@Composable
fun PreviewAuthorCard() {
    XLPPanelTheme {
        AuthorCard(AuthorInformation("Author","Body",R.drawable.pp))
    }
}

