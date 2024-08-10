package com.spiderindia.travelinsurance

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.spiderindia.travelinsurance.common.TIBaseActivity
import com.spiderindia.travelinsurance.databinding.FragmentLoginBinding
import com.spiderindia.travelinsurance.login.LoginViewModel
import com.spiderindia.travelinsurance.util.Resource

class LoginFragment : Fragment() {

    private val viewModel : LoginViewModel by lazy {
        ViewModelProvider (this).get(LoginViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val fragmentLogin = FragmentLoginBinding.inflate(inflater,container,false)
        fragmentLogin.viewModel = viewModel
        fragmentLogin.lifecycleOwner = this
        initUi(fragmentLogin)
        return fragmentLogin.root
    }

    private fun initUi(fragmentLogin: FragmentLoginBinding) {
        fragmentLogin.btnSignIn.setOnClickListener {
            viewModel.onClickLogin()
        }

        viewModel.liveLoginFlow.observe(viewLifecycleOwner, Observer {
            when(it)
            {
                Resource.Status.LOADING->
                {
                    (activity as TIBaseActivity).showProgressDialog("Login")
                }
                Resource.Status.ERROR->
                {
                    (activity as TIBaseActivity).dismissProgressDialog("Login")
                }
                else->{
                    (activity as TIBaseActivity).dismissProgressDialog("Login")
                }
            }
        })
    }
}