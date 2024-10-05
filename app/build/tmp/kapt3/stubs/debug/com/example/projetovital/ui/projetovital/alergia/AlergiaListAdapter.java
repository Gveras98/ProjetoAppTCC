package com.example.projetovital.ui.projetovital.alergia;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/example/projetovital/ui/projetovital/alergia/AlergiaListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/projetovital/ui/projetovital/alergia/AlergiaListAdapter$AlergiaViewHolder;", "alergiaList", "", "Lcom/example/projetovital/data/db/entity/AlergiaEntity;", "viewModel", "Lcom/example/projetovital/ui/projetovital/alergia/AlergiaViewModel;", "(Ljava/util/List;Lcom/example/projetovital/ui/projetovital/alergia/AlergiaViewModel;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "AlergiaViewHolder", "app_debug"})
public final class AlergiaListAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.projetovital.ui.projetovital.alergia.AlergiaListAdapter.AlergiaViewHolder> {
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.example.projetovital.data.db.entity.AlergiaEntity> alergiaList = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.projetovital.ui.projetovital.alergia.AlergiaViewModel viewModel = null;
    
    public AlergiaListAdapter(@org.jetbrains.annotations.NotNull
    java.util.List<com.example.projetovital.data.db.entity.AlergiaEntity> alergiaList, @org.jetbrains.annotations.NotNull
    com.example.projetovital.ui.projetovital.alergia.AlergiaViewModel viewModel) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.example.projetovital.ui.projetovital.alergia.AlergiaListAdapter.AlergiaViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.example.projetovital.ui.projetovital.alergia.AlergiaListAdapter.AlergiaViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/example/projetovital/ui/projetovital/alergia/AlergiaListAdapter$AlergiaViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "tvAlergiaNome", "Landroid/widget/TextView;", "bindView", "", "alergia", "Lcom/example/projetovital/data/db/entity/AlergiaEntity;", "app_debug"})
    public static final class AlergiaViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView tvAlergiaNome = null;
        
        public AlergiaViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View itemView) {
            super(null);
        }
        
        public final void bindView(@org.jetbrains.annotations.NotNull
        com.example.projetovital.data.db.entity.AlergiaEntity alergia) {
        }
    }
}