package com.example.projetovital.ui.projetovital.exames;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B/\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t\u00a2\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000eH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/example/projetovital/ui/projetovital/exames/ExamesListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/projetovital/ui/projetovital/exames/ExamesListAdapter$ExamesViewHolder;", "examesList", "", "Lcom/example/projetovital/data/db/entity/ExamesEntity;", "viewModel", "Lcom/example/projetovital/ui/projetovital/exames/ExamesViewModel;", "onAnexoClick", "Lkotlin/Function1;", "", "", "(Ljava/util/List;Lcom/example/projetovital/ui/projetovital/exames/ExamesViewModel;Lkotlin/jvm/functions/Function1;)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ExamesViewHolder", "app_debug"})
public final class ExamesListAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.projetovital.ui.projetovital.exames.ExamesListAdapter.ExamesViewHolder> {
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.example.projetovital.data.db.entity.ExamesEntity> examesList = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.projetovital.ui.projetovital.exames.ExamesViewModel viewModel = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> onAnexoClick = null;
    
    public ExamesListAdapter(@org.jetbrains.annotations.NotNull
    java.util.List<com.example.projetovital.data.db.entity.ExamesEntity> examesList, @org.jetbrains.annotations.NotNull
    com.example.projetovital.ui.projetovital.exames.ExamesViewModel viewModel, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onAnexoClick) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.example.projetovital.ui.projetovital.exames.ExamesListAdapter.ExamesViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.example.projetovital.ui.projetovital.exames.ExamesListAdapter.ExamesViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\"\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\r0\u0011R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/example/projetovital/ui/projetovital/exames/ExamesListAdapter$ExamesViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "btnExameAnexo", "Landroid/widget/Button;", "tvExameData", "Landroid/widget/TextView;", "tvExameEspecialidade", "tvExameLocal", "tvExameProcedimento", "bindView", "", "exames", "Lcom/example/projetovital/data/db/entity/ExamesEntity;", "onAnexoClick", "Lkotlin/Function1;", "", "app_debug"})
    public static final class ExamesViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView tvExameEspecialidade = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView tvExameData = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView tvExameLocal = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView tvExameProcedimento = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.Button btnExameAnexo = null;
        
        public ExamesViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View itemView) {
            super(null);
        }
        
        public final void bindView(@org.jetbrains.annotations.NotNull
        com.example.projetovital.data.db.entity.ExamesEntity exames, @org.jetbrains.annotations.NotNull
        kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onAnexoClick) {
        }
    }
}