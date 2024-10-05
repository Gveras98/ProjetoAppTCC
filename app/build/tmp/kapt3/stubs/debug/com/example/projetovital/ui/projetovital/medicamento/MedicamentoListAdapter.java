package com.example.projetovital.ui.projetovital.medicamento;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/example/projetovital/ui/projetovital/medicamento/MedicamentoListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/projetovital/ui/projetovital/medicamento/MedicamentoListAdapter$MedicamentoViewHolder;", "medicamentoList", "", "Lcom/example/projetovital/data/db/entity/MedicamentoEntity;", "viewModel", "Lcom/example/projetovital/ui/projetovital/medicamento/MedicamentoViewModel;", "(Ljava/util/List;Lcom/example/projetovital/ui/projetovital/medicamento/MedicamentoViewModel;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "MedicamentoViewHolder", "app_debug"})
public final class MedicamentoListAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.projetovital.ui.projetovital.medicamento.MedicamentoListAdapter.MedicamentoViewHolder> {
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.example.projetovital.data.db.entity.MedicamentoEntity> medicamentoList = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.projetovital.ui.projetovital.medicamento.MedicamentoViewModel viewModel = null;
    
    public MedicamentoListAdapter(@org.jetbrains.annotations.NotNull
    java.util.List<com.example.projetovital.data.db.entity.MedicamentoEntity> medicamentoList, @org.jetbrains.annotations.NotNull
    com.example.projetovital.ui.projetovital.medicamento.MedicamentoViewModel viewModel) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.example.projetovital.ui.projetovital.medicamento.MedicamentoListAdapter.MedicamentoViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.example.projetovital.ui.projetovital.medicamento.MedicamentoListAdapter.MedicamentoViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/example/projetovital/ui/projetovital/medicamento/MedicamentoListAdapter$MedicamentoViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "tvMedDose", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "tvMedDuracao", "tvMedIntervalo", "tvMedNome", "bindView", "", "medicamento", "Lcom/example/projetovital/data/db/entity/MedicamentoEntity;", "app_debug"})
    public static final class MedicamentoViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final android.widget.TextView tvMedNome = null;
        private final android.widget.TextView tvMedDose = null;
        private final android.widget.TextView tvMedDuracao = null;
        private final android.widget.TextView tvMedIntervalo = null;
        
        public MedicamentoViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View itemView) {
            super(null);
        }
        
        public final void bindView(@org.jetbrains.annotations.NotNull
        com.example.projetovital.data.db.entity.MedicamentoEntity medicamento) {
        }
    }
}