package com.notify.laywer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.core.view.get
import com.google.firebase.database.core.Context
/*
class ProcessAdapter  (val mCtx: Context,val resId: Int,val processList:
    List<Process>) : ArrayAdapter<Process>(mCtx,resId,processList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(mCtx);
        val view: View = layoutInflater.inflate(resId, null)
        val textViewname = view.findViewById<TextView>(R.id.textView);
        //val processList = view.findViewById<ListView>(R.id.list_process)
        val process = processList[position]

        textViewname.text = process.name
        //processList. = process.name
        //return super.getView(position, convertView, parent)
        return view;
    }
}*/