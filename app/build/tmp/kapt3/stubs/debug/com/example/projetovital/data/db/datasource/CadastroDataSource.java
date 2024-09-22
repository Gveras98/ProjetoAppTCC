package com.example.projetovital.data.db.datasource;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006H\u0016J\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\u0019\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"Lcom/example/projetovital/data/db/datasource/CadastroDataSource;", "Lcom/example/projetovital/data/db/repository/CadastroRepository;", "cadastroDao", "Lcom/example/projetovital/data/db/dao/CadastroDao;", "(Lcom/example/projetovital/data/db/dao/CadastroDao;)V", "getAllCadastros", "Landroidx/lifecycle/LiveData;", "", "Lcom/example/projetovital/data/db/entity/CadastroEntity;", "insertCadastro", "", "cadastro", "(Lcom/example/projetovital/data/db/entity/CadastroEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateCadastro", "", "app_debug"})
public final class CadastroDataSource implements com.example.projetovital.data.db.repository.CadastroRepository {
    @org.jetbrains.annotations.NotNull
    private final com.example.projetovital.data.db.dao.CadastroDao cadastroDao = null;
    
    public CadastroDataSource(@org.jetbrains.annotations.NotNull
    com.example.projetovital.data.db.dao.CadastroDao cadastroDao) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public androidx.lifecycle.LiveData<java.util.List<com.example.projetovital.data.db.entity.CadastroEntity>> getAllCadastros() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object insertCadastro(@org.jetbrains.annotations.NotNull
    com.example.projetovital.data.db.entity.CadastroEntity cadastro, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object updateCadastro(@org.jetbrains.annotations.NotNull
    com.example.projetovital.data.db.entity.CadastroEntity cadastro, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}