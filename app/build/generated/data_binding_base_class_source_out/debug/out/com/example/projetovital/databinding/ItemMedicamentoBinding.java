// Generated by view binder compiler. Do not edit!
package com.example.projetovital.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.projetovital.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemMedicamentoBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final Button btnMedDelete;

  @NonNull
  public final Button btnMedEditar;

  @NonNull
  public final TextView tvMedDose;

  @NonNull
  public final TextView tvMedDuracao;

  @NonNull
  public final TextView tvMedIntervalo;

  @NonNull
  public final TextView tvMedNome;

  private ItemMedicamentoBinding(@NonNull CardView rootView, @NonNull Button btnMedDelete,
      @NonNull Button btnMedEditar, @NonNull TextView tvMedDose, @NonNull TextView tvMedDuracao,
      @NonNull TextView tvMedIntervalo, @NonNull TextView tvMedNome) {
    this.rootView = rootView;
    this.btnMedDelete = btnMedDelete;
    this.btnMedEditar = btnMedEditar;
    this.tvMedDose = tvMedDose;
    this.tvMedDuracao = tvMedDuracao;
    this.tvMedIntervalo = tvMedIntervalo;
    this.tvMedNome = tvMedNome;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemMedicamentoBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemMedicamentoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_medicamento, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemMedicamentoBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnMedDelete;
      Button btnMedDelete = ViewBindings.findChildViewById(rootView, id);
      if (btnMedDelete == null) {
        break missingId;
      }

      id = R.id.btnMedEditar;
      Button btnMedEditar = ViewBindings.findChildViewById(rootView, id);
      if (btnMedEditar == null) {
        break missingId;
      }

      id = R.id.tvMedDose;
      TextView tvMedDose = ViewBindings.findChildViewById(rootView, id);
      if (tvMedDose == null) {
        break missingId;
      }

      id = R.id.tvMedDuracao;
      TextView tvMedDuracao = ViewBindings.findChildViewById(rootView, id);
      if (tvMedDuracao == null) {
        break missingId;
      }

      id = R.id.tvMedIntervalo;
      TextView tvMedIntervalo = ViewBindings.findChildViewById(rootView, id);
      if (tvMedIntervalo == null) {
        break missingId;
      }

      id = R.id.tvMedNome;
      TextView tvMedNome = ViewBindings.findChildViewById(rootView, id);
      if (tvMedNome == null) {
        break missingId;
      }

      return new ItemMedicamentoBinding((CardView) rootView, btnMedDelete, btnMedEditar, tvMedDose,
          tvMedDuracao, tvMedIntervalo, tvMedNome);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}