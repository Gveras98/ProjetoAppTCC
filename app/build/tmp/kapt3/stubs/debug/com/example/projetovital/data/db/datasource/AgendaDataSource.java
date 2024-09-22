package com.example.projetovital.data.db.datasource;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0014\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u000bH\u0016J\u0019\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0019\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2 = {"Lcom/example/projetovital/data/db/datasource/AgendaDataSource;", "Lcom/example/projetovital/data/db/repository/AgendaRepository;", "agendaDao", "Lcom/example/projetovital/data/db/dao/AgendaDao;", "(Lcom/example/projetovital/data/db/dao/AgendaDao;)V", "deleteAgenda", "", "agenda", "Lcom/example/projetovital/data/db/entity/AgendaEntity;", "(Lcom/example/projetovital/data/db/entity/AgendaEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllAgendas", "Landroidx/lifecycle/LiveData;", "", "insertAgenda", "", "updateAgenda", "app_debug"})
public final class AgendaDataSource implements com.example.projetovital.data.db.repository.AgendaRepository {
    @org.jetbrains.annotations.NotNull
    private final com.example.projetovital.data.db.dao.AgendaDao agendaDao = null;
    
    public AgendaDataSource(@org.jetbrains.annotations.NotNull
    com.example.projetovital.data.db.dao.AgendaDao agendaDao) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public androidx.lifecycle.LiveData<java.util.List<com.example.projetovital.data.db.entity.AgendaEntity>> getAllAgendas() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object insertAgenda(@org.jetbrains.annotations.NotNull
    com.example.projetovital.data.db.entity.AgendaEntity agenda, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object updateAgenda(@org.jetbrains.annotations.NotNull
    com.example.projetovital.data.db.entity.AgendaEntity agenda, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object deleteAgenda(@org.jetbrains.annotations.NotNull
    com.example.projetovital.data.db.entity.AgendaEntity agenda, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}