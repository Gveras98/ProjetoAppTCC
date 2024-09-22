package com.example.projetovital.data.db.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bH&J\u0019\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lcom/example/projetovital/data/db/repository/AgendaRepository;", "", "deleteAgenda", "", "agenda", "Lcom/example/projetovital/data/db/entity/AgendaEntity;", "(Lcom/example/projetovital/data/db/entity/AgendaEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllAgendas", "Landroidx/lifecycle/LiveData;", "", "insertAgenda", "", "updateAgenda", "app_debug"})
public abstract interface AgendaRepository {
    
    @org.jetbrains.annotations.NotNull
    public abstract androidx.lifecycle.LiveData<java.util.List<com.example.projetovital.data.db.entity.AgendaEntity>> getAllAgendas();
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertAgenda(@org.jetbrains.annotations.NotNull
    com.example.projetovital.data.db.entity.AgendaEntity agenda, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateAgenda(@org.jetbrains.annotations.NotNull
    com.example.projetovital.data.db.entity.AgendaEntity agenda, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteAgenda(@org.jetbrains.annotations.NotNull
    com.example.projetovital.data.db.entity.AgendaEntity agenda, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}