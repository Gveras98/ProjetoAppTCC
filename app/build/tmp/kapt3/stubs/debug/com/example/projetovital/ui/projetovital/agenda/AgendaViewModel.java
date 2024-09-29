package com.example.projetovital.ui.projetovital.agenda;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00182\u00020\u0001:\u0002\u0017\u0018B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0010R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001d\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/example/projetovital/ui/projetovital/agenda/AgendaViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/example/projetovital/data/db/repository/AgendaRepository;", "(Lcom/example/projetovital/data/db/repository/AgendaRepository;)V", "_agendaMessageEventData", "Landroidx/lifecycle/MutableLiveData;", "", "_agendaStateEventData", "Lcom/example/projetovital/ui/projetovital/agenda/AgendaViewModel$AgendaState;", "agendaStateEventData", "Landroidx/lifecycle/LiveData;", "getAgendaStateEventData", "()Landroidx/lifecycle/LiveData;", "exibirAgenda", "", "Lcom/example/projetovital/data/db/entity/AgendaEntity;", "getExibirAgenda", "messageEventData", "getMessageEventData", "inserirAgenda", "Lkotlinx/coroutines/Job;", "agenda", "AgendaState", "Companion", "app_debug"})
public final class AgendaViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.projetovital.data.db.repository.AgendaRepository repository = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<com.example.projetovital.ui.projetovital.agenda.AgendaViewModel.AgendaState> _agendaStateEventData = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Integer> _agendaMessageEventData = null;
    private static final java.lang.String TAG = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<java.util.List<com.example.projetovital.data.db.entity.AgendaEntity>> exibirAgenda = null;
    @org.jetbrains.annotations.NotNull
    public static final com.example.projetovital.ui.projetovital.agenda.AgendaViewModel.Companion Companion = null;
    
    public AgendaViewModel(@org.jetbrains.annotations.NotNull
    com.example.projetovital.data.db.repository.AgendaRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.example.projetovital.ui.projetovital.agenda.AgendaViewModel.AgendaState> getAgendaStateEventData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.lang.Integer> getMessageEventData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job inserirAgenda(@org.jetbrains.annotations.NotNull
    com.example.projetovital.data.db.entity.AgendaEntity agenda) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<com.example.projetovital.data.db.entity.AgendaEntity>> getExibirAgenda() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/example/projetovital/ui/projetovital/agenda/AgendaViewModel$AgendaState;", "", "()V", "Inserido", "Lcom/example/projetovital/ui/projetovital/agenda/AgendaViewModel$AgendaState$Inserido;", "app_debug"})
    public static abstract class AgendaState {
        
        private AgendaState() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/projetovital/ui/projetovital/agenda/AgendaViewModel$AgendaState$Inserido;", "Lcom/example/projetovital/ui/projetovital/agenda/AgendaViewModel$AgendaState;", "()V", "app_debug"})
        public static final class Inserido extends com.example.projetovital.ui.projetovital.agenda.AgendaViewModel.AgendaState {
            @org.jetbrains.annotations.NotNull
            public static final com.example.projetovital.ui.projetovital.agenda.AgendaViewModel.AgendaState.Inserido INSTANCE = null;
            
            private Inserido() {
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/example/projetovital/ui/projetovital/agenda/AgendaViewModel$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}