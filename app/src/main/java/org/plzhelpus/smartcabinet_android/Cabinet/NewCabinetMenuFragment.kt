package org.plzhelpus.smartcabinet_android.Cabinet


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_new_cabinet_menu.*

import org.plzhelpus.smartcabinet_android.R

class NewCabinetMenuFragment : Fragment() {
    private var mListener: NewCabinetMenuListener? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_new_cabinet_menu, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        add_to_exisetd_group_button.setOnClickListener {
            mListener!!.onAddButtonClicked()
        }

        create_new_group_button.setOnClickListener {
            mListener!!.onCreateButtonClicked()
        }

    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if(context is NewCabinetMenuListener) {
            mListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement NewCabinetMenuListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    interface NewCabinetMenuListener {
        fun onAddButtonClicked()
        fun onCreateButtonClicked()
    }
}
