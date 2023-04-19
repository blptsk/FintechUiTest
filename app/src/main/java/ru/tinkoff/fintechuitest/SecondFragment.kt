package ru.tinkoff.fintechuitest

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import ru.tinkoff.fintechuitest.databinding.FragmentSecondBinding


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    fun Context.hideKeyboard(view: View) {
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

        binding.edittextLogin.setOnFocusChangeListener { view: View, hasFocus: Boolean ->
            if (hasFocus)
                binding.edittextLogin.setHintTextColor(resources.getColor(R.color.default_color_hint))
        }
        binding.edittextPassword.setOnFocusChangeListener { view: View, hasFocus: Boolean ->
            if (hasFocus)
                binding.edittextPassword.setHintTextColor(resources.getColor(R.color.default_color_hint))
        }

        binding.buttonSubmit.setOnClickListener {

            view.let { activity?.hideKeyboard(it) }

            val loginValueFromET = binding.edittextLogin.text
            val passwordValueFromET = binding.edittextPassword.text

            var snackMessage : String = "You enter login = $loginValueFromET password = $passwordValueFromET"

            if (loginValueFromET.isEmpty()) {
                snackMessage = "Login field must be filled!"
                binding.edittextLogin.setHintTextColor(resources.getColor(R.color.error_hint))
            } else
                binding.edittextLogin.setHintTextColor(resources.getColor(R.color.default_color_hint))


            if (passwordValueFromET.isEmpty()){
                snackMessage = "Password field must be filled!"
                binding.edittextPassword.setHintTextColor(resources.getColor(R.color.error_hint))
            } else
                binding.edittextPassword.setHintTextColor(resources.getColor(R.color.default_color_hint))


            if (loginValueFromET.isEmpty() && passwordValueFromET.isEmpty())
                snackMessage = "Both of fields must be filled!"

            Snackbar.make(view, snackMessage, Snackbar.LENGTH_LONG)
                .setAnchorView(R.id.fab)
                .setAction("Action", null).show()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}