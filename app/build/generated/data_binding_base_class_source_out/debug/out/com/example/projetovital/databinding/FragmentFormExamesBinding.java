// Generated by view binder compiler. Do not edit!
package com.example.projetovital.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.projetovital.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentFormExamesBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button btnSalvar;

  @NonNull
  public final Button btnScanner;

  @NonNull
  public final EditText etData;

  @NonNull
  public final EditText etEspecialidade;

  @NonNull
  public final EditText etLocal;

  @NonNull
  public final EditText etProcedimento;

  private FragmentFormExamesBinding(@NonNull LinearLayout rootView, @NonNull Button btnSalvar,
      @NonNull Button btnScanner, @NonNull EditText etData, @NonNull EditText etEspecialidade,
      @NonNull EditText etLocal, @NonNull EditText etProcedimento) {
    this.rootView = rootView;
    this.btnSalvar = btnSalvar;
    this.btnScanner = btnScanner;
    this.etData = etData;
    this.etEspecialidade = etEspecialidade;
    this.etLocal = etLocal;
    this.etProcedimento = etProcedimento;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
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
      EditText etData = ViewBindings.findChildViewById(rootView, id);
      if (etData == null) {
        break missingId;
      }

      id = R.id.etEspecialidade;
      EditText etEspecialidade = ViewBindings.findChildViewById(rootView, id);
      if (etEspecialidade == null) {
        break missingId;
      }

      id = R.id.etLocal;
      EditText etLocal = ViewBindings.findChildViewById(rootView, id);
      if (etLocal == null) {
        break missingId;
      }

      id = R.id.etProcedimento;
      EditText etProcedimento = ViewBindings.findChildViewById(rootView, id);
      if (etProcedimento == null) {
        break missingId;
      }

      return new FragmentFormExamesBinding((LinearLayout) rootView, btnSalvar, btnScanner, etData,
          etEspecialidade, etLocal, etProcedimento);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
