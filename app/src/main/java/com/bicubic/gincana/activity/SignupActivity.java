package com.bicubic.gincana.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bicubic.gincana.R;
import com.bicubic.gincana.helper.GlobalUse;
import com.bicubic.gincana.model.Signin;
import com.bicubic.gincana.utils.ApiClient;
import com.bicubic.gincana.utils.ApiInterface;
import com.bicubic.gincana.utils.MyApplication;
import com.bicubic.gincana.widget.CustomTextView;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = SignupActivity.class.getSimpleName();
    CustomTextView tv_click_here;
    Button bt_signup;
    EditText et_email,et_name,et_password;
    //    facebook
    Button bt_fb_button;
    LoginButton fb_button;
    CallbackManager callbackManager;
    private String Name = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        FacebookSdk.sdkInitialize(SignupActivity.this);
        setContentView(R.layout.activity_signup);

        SharedPreferences settings = getSharedPreferences("preference", 0);
//Get "hasLoggedIn" value. If the value doesn't exist yet false is returned
        boolean hasLoggedIn = settings.getBoolean("hasLoggedIn", false);

        if (hasLoggedIn) {
            startActivity(new Intent(SignupActivity.this, HomeScreenActivity.class));
            finish();
            return;
        }

        tv_click_here = (CustomTextView) findViewById(R.id.tv_click_here);
        bt_signup = (Button) findViewById(R.id.bt_signup);
        et_email= (EditText) findViewById(R.id.et_email);
        et_name= (EditText) findViewById(R.id.et_name);
        et_password= (EditText) findViewById(R.id.et_password);
        bt_fb_button = (Button) findViewById(R.id.bt_fb_button);
        fb_button = (LoginButton) findViewById(R.id.fb_button);

        callbackManager = CallbackManager.Factory.create();
//        fb_button.setReadPermissions(Arrays.asList("public_profile, email, user_birthday, user_friends"));

//        bt_fb_button.setOnClickListener(this);
//        bt_signup.setOnClickListener(this);
//        tv_click_here.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.tv_click_here:
                startActivity(new Intent(SignupActivity.this, SigninActivity.class));
                break;

            case R.id.bt_signup:

                startActivity(new Intent(SignupActivity.this, TutorialActivity.class));

                /*if (TextUtils.isEmpty(et_name.getText().toString())){

                    MyApplication.okMessageDialog(SignupActivity.this,"Gincana","Enter name !");

                } else if (!GlobalUse.isValidEmail(et_email.getText().toString())) {

                    MyApplication.okMessageDialog(SignupActivity.this,"Gincana","Email not valid");

                }else if (!(et_password.getText().toString().length()>=8) && !GlobalUse.isValidPassword(et_password.getText().toString())){

                    MyApplication.okMessageDialog(SignupActivity.this,"Gincana","Password must be 8 characters long including alphanumeric characters with at least 1 uppercase letter,1 lowercase letter,1 special character and 1 digit \n\n For Example\nGincana@009");

                }else {

//                    Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
                    CheckEmailSignupProcess();

                }*/
                break;

            case R.id.bt_fb_button:

                LoginManager.getInstance().logOut();

                FaceBookLogin();
                LoginManager.getInstance().logInWithReadPermissions(SignupActivity.this, Arrays.asList("public_profile, email, user_birthday, user_friends"));

                break;
        }

    }



    private void FaceBookLogin() {

        fb_button.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {

            @Override
            public void onSuccess(LoginResult loginResult) {

                // App code
                GraphRequest request = GraphRequest.newMeRequest(
                        loginResult.getAccessToken(),
                        new GraphRequest.GraphJSONObjectCallback() {
                            @Override
                            public void onCompleted(
                                    JSONObject object,
                                    GraphResponse response) {
                                // Application code
                                Log.v("Profile ---------   ", response.toString());

                                try {

                                    Toast.makeText(SignupActivity.this, "heyyy", Toast.LENGTH_SHORT).show();


                                    if (object != null) {

                                        if (object.has("first_name"))
                                            Name = object.getString("name");

                                        Toast.makeText(SignupActivity.this, "Welcome  " + Name, Toast.LENGTH_SHORT).show();
                                        Log.d(TAG, "onCompleted: Name - " + object.getString("name"));

                                    } else
                                        Log.d(TAG, "onCompleted: object is null " + object);

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }
                        });

            }

            @Override
            public void onCancel() {
//                FaceBookLogin();
//                LoginManager.getInstance().logInWithReadPermissions(SigninActivity.this, Arrays.asList("public_profile, email, user_birthday, user_friends"));
                Toast.makeText(SignupActivity.this, "Facebook login cancel", Toast.LENGTH_SHORT).show();
                System.out.println("Facebook Login Cancel!!");

            }

            @Override
            public void onError(FacebookException e) {
                Toast.makeText(getApplicationContext(), "Something went wrong!!", Toast.LENGTH_LONG).show();
                //                System.out.println("Facebook Login failed!! because of " + e.getCause().toString());
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);

    }

    public void CheckEmailSignupProcess() {

        startActivity(new Intent(SignupActivity.this, TutorialActivity.class));


//        TelephonyManager telephonyManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
//        IMEI = telephonyManager.getDeviceId();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        final ProgressDialog progressDialog = new ProgressDialog(SignupActivity.this);
        progressDialog.setMessage("Please Wait....");
        progressDialog.show();

        Map<String, RequestBody> map = new HashMap<>();
        map.put("action", GlobalUse.toRequestBody("register"));
        map.put("Email", GlobalUse.toRequestBody(et_email.getText().toString()));
        map.put("Password", GlobalUse.toRequestBody(et_password.getText().toString()));
        map.put("Name", GlobalUse.toRequestBody(et_name.getText().toString()));
//        map.put("loginAccessFrom", GlobalUse.toRequestBody("E"));

        Call<Signin> responseCall = apiInterface.CheckSimpleRegister(map);

        responseCall.enqueue(new Callback<Signin>() {
            @Override
            public void onResponse(Call<Signin> call, Response<Signin> response) {

                if (progressDialog.isShowing())
                    progressDialog.dismiss();

                Signin s = response.body();

                if (s.getResponse().isResult()) {

                    Log.i(TAG, "onResponse: message :" + s.getResponse().getErrorDescription());

                    Log.i(TAG, "onResponse: " + s.getResponse().toString());

                    SharedPreferences settings = getSharedPreferences("preference", 0); // 0 - for private mode
                    SharedPreferences.Editor editor = settings.edit();
//                    editor.putString("name", s.getData().getName());
                    Log.i(TAG, "onResponse: userid : "+s.getResponse().getUserId());

                    editor.putString("userid", s.getResponse().getUserId());
                    editor.putBoolean("hasLoggedIn", true);
                    editor.apply();

                    startActivity(new Intent(SignupActivity.this, TutorialActivity.class));

                } else {
                    Toast.makeText(SignupActivity.this, "" + s.getResponse().getErrorDescription(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<Signin> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
                if (progressDialog.isShowing())
                    progressDialog.dismiss();

                MyApplication.okMessageDialog(SignupActivity.this,"Gincana",t.getMessage());

            }
        });

    }


}
