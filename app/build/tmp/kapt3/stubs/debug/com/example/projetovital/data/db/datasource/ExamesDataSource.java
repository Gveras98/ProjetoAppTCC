package com.example.projetovital.data.db.datasource;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0014\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u000bH\u0016J\u0019\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0019\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"Lcom/example/projetovital/data/db/datasource/ExamesDataSource;", "Lcom/example/projetovital/data/db/repository/ExamesRepository;", "examesDao", "Lcom/example/projetovital/data/db/dao/ExamesDao;", "(Lcom/example/projetovital/data/db/dao/ExamesDao;)V", "deleteExame", "", "exames", "Lcom/example/projetovital/data/db/entity/ExamesEntity;", "(Lcom/example/projetovital/data/db/entity/ExamesEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllExames", "Landroidx/lifecycle/LiveData;", "", "insertExame", "updateExame", "app_debug"})
public final class ExamesDataSource implements com.example.projetovital.data.db.repository.ExamesRepository {
    @org.jetbrains.annotations.NotNull
    private final com.example.projetovital.data.db.dao.ExamesDao examesDao = null;
    
    public ExamesDataSource(@org.jetbrains.annotations.NotNull
    com.example.projetovital.data.db.dao.ExamesDao examesDao) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public androidx.lifecycle.LiveData<java.util.List<com.example.projetovital.data.db.entity.ExamesEntity>> getAllExames() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object insertExame(@org.jetbrains.annotations.NotNull
    com.example.projetovital.data.db.entity.ExamesEntity exames, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object updateExame(@org.jetbrains.annotations.NotNull
    com.example.projetovital.data.db.entity.ExamesEntity exames, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object deleteExame(@org.jetbrains.annotations.NotNull
    com.example.projetovital.data.db.entity.ExamesEntity exames, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}