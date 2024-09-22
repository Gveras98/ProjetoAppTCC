package com.example.projetovital.data.db.entity;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\tH\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0005H\u00c6\u0003JE\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010!\u001a\u00020\"H\u00d6\u0001J\t\u0010#\u001a\u00020\u0005H\u00d6\u0001R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0016\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010\u00a8\u0006$"}, d2 = {"Lcom/example/projetovital/data/db/entity/AgendaEntity;", "", "idAgenda", "", "especialidadeAgenda", "", "dataAgenda", "Ljava/util/Date;", "horaAgenda", "Ljava/time/LocalTime;", "localAgenda", "procedimentoAgenda", "(JLjava/lang/String;Ljava/util/Date;Ljava/time/LocalTime;Ljava/lang/String;Ljava/lang/String;)V", "getDataAgenda", "()Ljava/util/Date;", "getEspecialidadeAgenda", "()Ljava/lang/String;", "getHoraAgenda", "()Ljava/time/LocalTime;", "getIdAgenda", "()J", "getLocalAgenda", "getProcedimentoAgenda", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
@androidx.room.Entity(tableName = "tblAgenda")
public final class AgendaEntity {
    @androidx.room.ColumnInfo(name = "idAgenda")
    @androidx.room.PrimaryKey(autoGenerate = true)
    private final long idAgenda = 0L;
    @androidx.room.ColumnInfo(name = "especialidadeAgenda")
    @org.jetbrains.annotations.NotNull
    private final java.lang.String especialidadeAgenda = null;
    @androidx.room.ColumnInfo(name = "dataAgenda")
    @org.jetbrains.annotations.NotNull
    private final java.util.Date dataAgenda = null;
    @androidx.room.ColumnInfo(name = "horaAgenda")
    @org.jetbrains.annotations.NotNull
    private final java.time.LocalTime horaAgenda = null;
    @androidx.room.ColumnInfo(name = "localAgenda")
    @org.jetbrains.annotations.NotNull
    private final java.lang.String localAgenda = null;
    @androidx.room.ColumnInfo(name = "procedimentoAgenda")
    @org.jetbrains.annotations.NotNull
    private final java.lang.String procedimentoAgenda = null;
    
    public AgendaEntity(long idAgenda, @org.jetbrains.annotations.NotNull
    java.lang.String especialidadeAgenda, @org.jetbrains.annotations.NotNull
    java.util.Date dataAgenda, @org.jetbrains.annotations.NotNull
    java.time.LocalTime horaAgenda, @org.jetbrains.annotations.NotNull
    java.lang.String localAgenda, @org.jetbrains.annotations.NotNull
    java.lang.String procedimentoAgenda) {
        super();
    }
    
    public final long getIdAgenda() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getEspecialidadeAgenda() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Date getDataAgenda() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.time.LocalTime getHoraAgenda() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getLocalAgenda() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getProcedimentoAgenda() {
        return null;
    }
    
    public final long component1() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Date component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.time.LocalTime component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.projetovital.data.db.entity.AgendaEntity copy(long idAgenda, @org.jetbrains.annotations.NotNull
    java.lang.String especialidadeAgenda, @org.jetbrains.annotations.NotNull
    java.util.Date dataAgenda, @org.jetbrains.annotations.NotNull
    java.time.LocalTime horaAgenda, @org.jetbrains.annotations.NotNull
    java.lang.String localAgenda, @org.jetbrains.annotations.NotNull
    java.lang.String procedimentoAgenda) {
        return null;
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return null;
    }
}