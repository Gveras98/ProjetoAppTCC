package com.example.projetovital.data.db.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H&J\u0019\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0019\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lcom/example/projetovital/data/db/repository/CadastroRepository;", "", "getAllCadastros", "Landroidx/lifecycle/LiveData;", "", "Lcom/example/projetovital/data/db/entity/CadastroEntity;", "insertCadastro", "", "cadastro", "(Lcom/example/projetovital/data/db/entity/CadastroEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateCadastro", "", "app_debug"})
public abstract interface CadastroRepository {
    
    @org.jetbrains.annotations.NotNull
    public abstract androidx.lifecycle.LiveData<java.util.List<com.example.projetovital.data.db.entity.CadastroEntity>> getAllCadastros();
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertCadastro(@org.jetbrains.annotations.NotNull
    com.example.projetovital.data.db.entity.CadastroEntity cadastro, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateCadastro(@org.jetbrains.annotations.NotNull
    com.example.projetovital.data.db.entity.CadastroEntity cadastro, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}