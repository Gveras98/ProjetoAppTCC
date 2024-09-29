// Generated by view binder compiler. Do not edit!
package com.example.projetovital.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.projetovital.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentExamesBinding implements ViewBinding {
  @NonNull
  private final ScrollView rootView;

  @NonNull
  public final Button btnCadExames;

  @NonNull
  public final RecyclerView recyclerExames;

  private FragmentExamesBinding(@NonNull ScrollView rootView, @NonNull Button btnCadExames,
      @NonNull RecyclerView recyclerExames) {
    this.rootView = rootView;
    this.btnCadExames = btnCadExames;
    this.recyclerExames = recyclerExames;
  }

  @Override
  @NonNull
  public ScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentExamesBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentExamesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_exames, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentExamesBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_Cad_Exames;
      Button btnCadExames = ViewBindings.findChildViewById(rootView, id);
      if (btnCadExames == null) {
        break missingId;
      }

      id = R.id.recyclerExames;
      RecyclerView recyclerExames = ViewBindings.findChildViewById(rootView, id);
      if (recyclerExames == null) {
        break missingId;
      }

      return new FragmentExamesBinding((ScrollView) rootView, btnCadExames, recyclerExames);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
