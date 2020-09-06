package com.notify.laywer

import com.google.firebase.database.IgnoreExtraProperties
import java.util.*

//class Process (val process_id:String,val client_id:String,val name:String,val date_start:String,date_end:String)
//{
    //constructor():this(1,1,"","2020-01-01","01/01/2020"){}

//}

@IgnoreExtraProperties
data class Process(
    var process_id:String? = "",
    var client_id:String? = "",
    var name:String? = "",
    var date_start:String? = "",
    var date_end:String? = ""
)