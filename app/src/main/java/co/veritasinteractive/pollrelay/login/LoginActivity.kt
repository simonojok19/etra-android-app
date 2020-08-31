package co.veritasinteractive.pollrelay.login

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import androidx.lifecycle.ViewModelProviders
import co.veritasinteractive.pollrelay.R
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {
    private lateinit var loginActivityViewModel: LoginActivityViewModel;
    private lateinit var username: EditText
    private lateinit var password: EditText
    private lateinit var login: Button
    private lateinit var loading : ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginActivityViewModel = ViewModelProviders.of(this).get(LoginActivityViewModel::class.java)

        username = findViewById<EditText>(R.id.username)
        password = findViewById<EditText>(R.id.password)
        login = findViewById<Button>(R.id.login)
        loading = findViewById<ProgressBar>(R.id.loading)

    }

    fun login(view: View) {
        loading.visibility = View.VISIBLE
        loginActivityViewModel.loginUser(username.text.toString(), password.text.toString())
    }


}