package com.example.testcodeforhospitalmanagement

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.data.EmptyGroup.name
import androidx.compose.ui.tooling.preview.Preview
import com.chaquo.python.PyObject
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform
import com.example.testcodeforhospitalmanagement.ui.theme.TestCodeForHospitalManagementTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestCodeForHospitalManagementTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting(getData())
                }
            }
        }
        initPython()
    }
    private fun initPython() {
        if (! Python.isStarted()) {
            Python.start(AndroidPlatform(this))
        }
    }

    private fun getData(): PyObject? {
        val python = Python.getInstance()
        val pythonFile = python.getModule("script")
        return pythonFile.callAttr("fetch_data", "Doctor")
    }
}

@Composable
fun printing(name: PyObject) {
    var text = ""
    for (i in name){
        for (j in i){
            text  = text + j + " "
        }
    }
    Text(text = "$text")
}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    TestCodeForHospitalManagementTheme {
//        printing("hello")
//    }
//}