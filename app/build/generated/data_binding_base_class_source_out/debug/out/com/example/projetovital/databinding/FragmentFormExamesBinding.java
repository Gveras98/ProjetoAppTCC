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

public final class FragmentFormExamesBinding implements ViewBinding {
  @NonNull
  private final ScrollView rootView;

  @NonNull
  public final TextInputLayout EtEspecialidade;

  @NonNull
  public final Button btnSalvar;

  @NonNull
  public final Button btnScanner;

  @NonNull
  public final TextInputEditText etData;

  @NonNull
  public final TextInputEditText etExameEspecialidade;

  @NonNull
  public final TextInputEditText etLocal;

  @NonNull
  public final TextInputEditText etProcedimento;

  @NonNull
  public final TextInputLayout inputEtData;

  @NonNull
  public final TextInputLayout inputEtLocal;

  @NonNull
  public final TextInputLayout inputEtProcedimento;

  private FragmentFormExamesBinding(@NonNull ScrollView rootView,
      @NonNull TextInputLayout EtEspecialidade, @NonNull Button btnSalvar,
      @NonNull Button btnScanner, @NonNull TextInputEditText etData,
      @NonNull TextInputEditText etExameEspecialidade, @NonNull TextInputEditText etLocal,
      @NonNull TextInputEditText etProcedimento, @NonNull TextInputLayout inputEtData,
      @NonNull TextInputLayout inputEtLocal, @NonNull TextInputLayout inputEtProcedimento) {
    this.rootView = rootView;
    this.EtEspecialidade = EtEspecialidade;
    this.btnSalvar = btnSalvar;
    this.btnScanner = btnScanner;
    this.etData = etData;
    this.etExameEspecialidade = etExameEspecialidade;
    this.etLocal = etLocal;
    this.etProcedimento = etProcedimento;
    this.inputEtData = inputEtData;
    this.inputEtLocal = inputEtLocal;
    this.inputEtProcedimento = inputEtProcedimento;
  }

  @Override
  @NonNull
  public ScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentFormExamesBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentFormExamesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_form_exames, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentFormExamesBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.EtEspecialidade;
      TextInputLayout EtEspecialidade = ViewBindings.findChildViewById(rootView, id);
      if (EtEspecialidade == null) {
        break missingId;
      }

      id = R.id.btnSalvar;
      Button btnSalvar = ViewBindings.findChildViewById(rootView, id);
      if (btnSalvar == null) {
        break missingId;
      }

      id = R.id.btnScanner;
      Button btnScanner = ViewBindings.findChildViewById(rootView, id);
      if (btnScanner == null) {
        break missingId;
      }

      id = R.id.etData;
      TextInputEditText etData = ViewBindings.findChildViewById(rootView, id);
      if (etData == null) {
        break missingId;
      }

      id = R.id.etExameEspecialidade;
      TextInputEditText etExameEspecialidade = ViewBindings.findChildViewById(rootView, id);
      if (etExameEspecialidade == null) {
        break missingId;
      }

      id = R.id.etLocal;
      TextInputEditText etLocal = ViewBindings.findChildViewById(rootView, id);
      if (etLocal == null) {
        break missingId;
      }

      id = R.id.etProcedimento;
      TextInputEditText etProcedimento = ViewBindings.findChildViewById(rootView, id);
      if (etProcedimento == null) {
        break missingId;
      }

      id = R.id.inputEtData;
      TextInputLayout inputEtData = ViewBindings.findChildViewById(rootView, id);
      if (inputEtData == null) {
        break missingId;
      }

      id = R.id.inputEtLocal;
      TextInputLayout inputEtLocal = ViewBindings.findChildViewById(rootView, id);
      if (inputEtLocal == null) {
        break missingId;
      }

      id = R.id.inputEtProcedimento;
      TextInputLayout inputEtProcedimento = ViewBindings.findChildViewById(rootView, id);
      if (inputEtProcedimento == null) {
        break missingId;
      }

      return new FragmentFormExamesBinding((ScrollView) rootView, EtEspecialidade, btnSalvar,
          btnScanner, etData, etExameEspecialidade, etLocal, etProcedimento, inputEtData,
          inputEtLocal, inputEtProcedimento);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
