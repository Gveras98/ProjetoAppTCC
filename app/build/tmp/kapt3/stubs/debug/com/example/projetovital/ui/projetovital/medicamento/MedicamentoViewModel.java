package com.example.projetovital.ui.projetovital.medicamento;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u0001:\u0002\u0017\u0018B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\rR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/example/projetovital/ui/projetovital/medicamento/MedicamentoViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/example/projetovital/data/db/repository/MedicamentoRepository;", "(Lcom/example/projetovital/data/db/repository/MedicamentoRepository;)V", "_medicamentoMessageEventData", "Landroidx/lifecycle/MutableLiveData;", "", "_medicamentoStateEventData", "Lcom/example/projetovital/ui/projetovital/medicamento/MedicamentoViewModel$MedicamentoState;", "exibirMedicamento", "Landroidx/lifecycle/LiveData;", "", "Lcom/example/projetovital/data/db/entity/MedicamentoEntity;", "getExibirMedicamento", "()Landroidx/lifecycle/LiveData;", "medicamentoStateEventData", "getMedicamentoStateEventData", "messageEventData", "getMessageEventData", "inserirMedicamento", "Lkotlinx/coroutines/Job;", "medicamento", "Companion", "MedicamentoState", "app_debug"})
public final class MedicamentoViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.projetovital.data.db.repository.MedicamentoRepository repository = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<com.example.projetovital.ui.projetovital.medicamento.MedicamentoViewModel.MedicamentoState> _medicamentoStateEventData = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Integer> _medicamentoMessageEventData = null;
    private static final java.lang.String TAG = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<java.util.List<com.example.projetovital.data.db.entity.MedicamentoEntity>> exibirMedicamento = null;
    @org.jetbrains.annotations.NotNull
    public static final com.example.projetovital.ui.projetovital.medicamento.MedicamentoViewModel.Companion Companion = null;
    
    public MedicamentoViewModel(@org.jetbrains.annotations.NotNull
    com.example.projetovital.data.db.repository.MedicamentoRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.example.projetovital.ui.projetovital.medicamento.MedicamentoViewModel.MedicamentoState> getMedicamentoStateEventData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.lang.Integer> getMessageEventData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job inserirMedicamento(@org.jetbrains.annotations.NotNull
    com.example.projetovital.data.db.entity.MedicamentoEntity medicamento) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<com.example.projetovital.data.db.entity.MedicamentoEntity>> getExibirMedicamento() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/example/projetovital/ui/projetovital/medicamento/MedicamentoViewModel$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/example/projetovital/ui/projetovital/medicamento/MedicamentoViewModel$MedicamentoState;", "", "()V", "Inserido", "Lcom/example/projetovital/ui/projetovital/medicamento/MedicamentoViewModel$MedicamentoState$Inserido;", "app_debug"})
    public static abstract class MedicamentoState {
        
        private MedicamentoState() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/projetovital/ui/projetovital/medicamento/MedicamentoViewModel$MedicamentoState$Inserido;", "Lcom/example/projetovital/ui/projetovital/medicamento/MedicamentoViewModel$MedicamentoState;", "()V", "app_debug"})
        public static final class Inserido extends com.example.projetovital.ui.projetovital.medicamento.MedicamentoViewModel.MedicamentoState {
            @org.jetbrains.annotations.NotNull
            public static final com.example.projetovital.ui.projetovital.medicamento.MedicamentoViewModel.MedicamentoState.Inserido INSTANCE = null;
            
            private Inserido() {
            }
        }
    }
}