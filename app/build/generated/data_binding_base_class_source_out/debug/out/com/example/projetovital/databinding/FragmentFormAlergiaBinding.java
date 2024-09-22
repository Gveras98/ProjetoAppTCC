// Generated by view binder compiler. Do not edit!
package com.example.projetovital.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.projetovital.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentFormAlergiaBinding implements ViewBinding {
  @NonNull
  private final ScrollView rootView;

  @NonNull
  public final Button btnAlergiaSalvar;

  @NonNull
  public final TextInputEditText etAlergiaNome;

  @NonNull
  public final TextInputLayout inputEtAlergiaNome;

  private FragmentFormAlergiaBinding(@NonNull ScrollView rootView, @NonNull Button btnAlergiaSalvar,
      @NonNull TextInputEditText etAlergiaNome, @NonNull TextInputLayout inputEtAlergiaNome) {
    this.rootView = rootView;
    this.btnAlergiaSalvar = btnAlergiaSalvar;
    this.etAlergiaNome = etAlergiaNome;
    this.inputEtAlergiaNome = inputEtAlergiaNome;
  }

  @Override
  @NonNull
  public ScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentFormAlergiaBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentFormAlergiaBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_form_alergia, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentFormAlergiaBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnAlergiaSalvar;
      Button btnAlergiaSalvar = ViewBindings.findChildViewById(rootView, id);
      if (btnAlergiaSalvar == null) {
        break missingId;
      }

      id = R.id.etAlergiaNome;
      TextInputEditText etAlergiaNome = ViewBindings.findChildViewById(rootView, id);
      if (etAlergiaNome == null) {
        break missingId;
      }

      id = R.id.inputEtAlergiaNome;
      TextInputLayout inputEtAlergiaNome = ViewBindings.findChildViewById(rootView, id);
      if (inputEtAlergiaNome == null) {
        break missingId;
      }

      return new FragmentFormAlergiaBinding((ScrollView) rootView, btnAlergiaSalvar, etAlergiaNome,
          inputEtAlergiaNome);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
