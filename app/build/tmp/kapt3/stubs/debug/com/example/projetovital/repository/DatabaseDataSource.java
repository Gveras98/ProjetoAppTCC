package com.example.projetovital.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006H\u0016J\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\u0019\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"Lcom/example/projetovital/repository/DatabaseDataSource;", "Lcom/example/projetovital/repository/CadastroRepository;", "cadastroDao", "Lcom/example/projetovital/data/db/dao/CadastroDao;", "(Lcom/example/projetovital/data/db/dao/CadastroDao;)V", "getAll", "Landroidx/lifecycle/LiveData;", "", "Lcom/example/projetovital/data/db/entity/CadastroEntity;", "insert", "", "cadastro", "(Lcom/example/projetovital/data/db/entity/CadastroEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "update", "app_debug"})
public final class DatabaseDataSource implements com.example.projetovital.repository.CadastroRepository {
    @org.jetbrains.annotations.NotNull
    private final com.example.projetovital.data.db.dao.CadastroDao cadastroDao = null;
    
    public DatabaseDataSource(@org.jetbrains.annotations.NotNull
    com.example.projetovital.data.db.dao.CadastroDao cadastroDao) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public androidx.lifecycle.LiveData<java.util.List<com.example.projetovital.data.db.entity.CadastroEntity>> getAll() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object insert(@org.jetbrains.annotations.NotNull
    com.example.projetovital.data.db.entity.CadastroEntity cadastro, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object update(@org.jetbrains.annotations.NotNull
    com.example.projetovital.data.db.entity.CadastroEntity cadastro, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}