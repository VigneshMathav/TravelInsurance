package com.spiderindia.travelinsurance.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.TextView.OnEditorActionListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.spiderindia.travelinsurance.R
import com.spiderindia.travelinsurance.common.TIBaseActivity
import com.spiderindia.travelinsurance.databinding.FragmentRegistrationBinding
import com.spiderindia.travelinsurance.util.Resource

class RegistrationFragment : Fragment() {

    private val viewModel : RegistrationViewModel by lazy{
        ViewModelProvider(this).get(RegistrationViewModel::class.java)

    }

    override fun onCreate(savedInstanceState : Bundle?)
    {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentRegister = FragmentRegistrationBinding.inflate(inflater,container,false)
        fragmentRegister.viewModel = viewModel
        fragmentRegister.lifecycleOwner = this
        initUI(fragmentRegister)
        return fragmentRegister.root
    }

    private fun initUI(fragmentRegister: FragmentRegistrationBinding) {

        fragmentRegister.btnSignIn.setOnClickListener {
            navigateToDashBoard(fragmentRegister.edtConfirmPassword.text.toString())
        }

        fragmentRegister.edtConfirmPassword.setOnEditorActionListener(OnEditorActionListener { v, actionId, event ->

            if (actionId == EditorInfo.IME_ACTION_DONE)
            {
                navigateToDashBoard(v.text.toString())
                true
            }
            else false
        })

        viewModel.liveRegisterFlow.observe(viewLifecycleOwner, Observer {
            when(it)
            {
                Resource.Status.LOADING->{
                    (activity as TIBaseActivity).showProgressDialog("Register")
                }
                Resource.Status.SUCCESS->{
                    (activity as TIBaseActivity).dismissProgressDialog("Register")
                    findNavController().navigate(R.id.action_registrationFragment_to_homeFragment)
                    viewModel.liveRegisterFlow.postValue(Resource.Status.NONE)
                }
                else->
                {
                    (activity as TIBaseActivity).dismissProgressDialog("Register")
                }
            }

        } )
    }

    private fun navigateToDashBoard(confirmPassword : String) {
        viewModel.isValidInput(confirmPassword)
    }

}