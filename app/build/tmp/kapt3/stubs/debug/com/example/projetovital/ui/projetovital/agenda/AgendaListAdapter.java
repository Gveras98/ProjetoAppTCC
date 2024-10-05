package com.example.projetovital.ui.projetovital.agenda;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/example/projetovital/ui/projetovital/agenda/AgendaListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/projetovital/ui/projetovital/agenda/AgendaListAdapter$AgendaViewHolder;", "agendaList", "", "Lcom/example/projetovital/data/db/entity/AgendaEntity;", "viewModel", "Lcom/example/projetovital/ui/projetovital/agenda/AgendaViewModel;", "(Ljava/util/List;Lcom/example/projetovital/ui/projetovital/agenda/AgendaViewModel;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "AgendaViewHolder", "app_debug"})
public final class AgendaListAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.projetovital.ui.projetovital.agenda.AgendaListAdapter.AgendaViewHolder> {
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.example.projetovital.data.db.entity.AgendaEntity> agendaList = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.projetovital.ui.projetovital.agenda.AgendaViewModel viewModel = null;
    
    public AgendaListAdapter(@org.jetbrains.annotations.NotNull
    java.util.List<com.example.projetovital.data.db.entity.AgendaEntity> agendaList, @org.jetbrains.annotations.NotNull
    com.example.projetovital.ui.projetovital.agenda.AgendaViewModel viewModel) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.example.projetovital.ui.projetovital.agenda.AgendaListAdapter.AgendaViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.example.projetovital.ui.projetovital.agenda.AgendaListAdapter.AgendaViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/example/projetovital/ui/projetovital/agenda/AgendaListAdapter$AgendaViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "tvAgendaData", "Landroid/widget/TextView;", "tvAgendaEspecialidade", "tvAgendaHora", "tvAgendaLocal", "tvAgendaProcedimento", "bindView", "", "agenda", "Lcom/example/projetovital/data/db/entity/AgendaEntity;", "app_debug"})
    public static final class AgendaViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView tvAgendaEspecialidade = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView tvAgendaData = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView tvAgendaHora = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView tvAgendaLocal = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView tvAgendaProcedimento = null;
        
        public AgendaViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View itemView) {
            super(null);
        }
        
        public final void bindView(@org.jetbrains.annotations.NotNull
        com.example.projetovital.data.db.entity.AgendaEntity agenda) {
        }
    }
}