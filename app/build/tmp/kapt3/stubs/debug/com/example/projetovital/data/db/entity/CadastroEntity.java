package com.example.projetovital.data.db.entity;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bo\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0013J\t\u0010%\u001a\u00020\u0003H\u00c6\u0003J\t\u0010&\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\'\u001a\u00020\u0005H\u00c6\u0003J\t\u0010(\u001a\u00020\u0005H\u00c6\u0003J\t\u0010)\u001a\u00020\u0005H\u00c6\u0003J\t\u0010*\u001a\u00020\u0005H\u00c6\u0003J\t\u0010+\u001a\u00020\u0007H\u00c6\u0003J\t\u0010,\u001a\u00020\tH\u00c6\u0003J\t\u0010-\u001a\u00020\u0005H\u00c6\u0003J\t\u0010.\u001a\u00020\u0005H\u00c6\u0003J\t\u0010/\u001a\u00020\u0005H\u00c6\u0003J\t\u00100\u001a\u00020\u0005H\u00c6\u0003J\t\u00101\u001a\u00020\u0005H\u00c6\u0003J\u008b\u0001\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u0005H\u00c6\u0001J\u0013\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00106\u001a\u000207H\u00d6\u0001J\t\u00108\u001a\u00020\u0005H\u00d6\u0001R\u0016\u0010\f\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u000e\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0016\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015R\u0016\u0010\u0011\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015R\u0016\u0010\u000f\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0015R\u0016\u0010\u0010\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0015R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0016\u0010\r\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0015R\u0016\u0010\u0012\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0015\u00a8\u00069"}, d2 = {"Lcom/example/projetovital/data/db/entity/CadastroEntity;", "", "idUser", "", "nomeUser", "", "sexoUser", "", "dataNascimentoUser", "Ljava/util/Date;", "cpfUser", "enderecoUser", "cepUsuarioUser", "telefoneUser", "emailUser", "numSusUser", "planoSaudeUser", "numPlanoSaudeUser", "tipoSanguineoUser", "(JLjava/lang/String;CLjava/util/Date;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCepUsuarioUser", "()Ljava/lang/String;", "getCpfUser", "getDataNascimentoUser", "()Ljava/util/Date;", "getEmailUser", "getEnderecoUser", "getIdUser", "()J", "getNomeUser", "getNumPlanoSaudeUser", "getNumSusUser", "getPlanoSaudeUser", "getSexoUser", "()C", "getTelefoneUser", "getTipoSanguineoUser", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
@androidx.room.Entity(tableName = "tblCadastro")
public final class CadastroEntity {
    @androidx.room.ColumnInfo(name = "idUser")
    @androidx.room.PrimaryKey(autoGenerate = true)
    private final long idUser = 0L;
    @androidx.room.ColumnInfo(name = "nomeUser")
    @org.jetbrains.annotations.NotNull
    private final java.lang.String nomeUser = null;
    @androidx.room.ColumnInfo(name = "sexoUser")
    private final char sexoUser = '\u0000';
    @androidx.room.ColumnInfo(name = "dataNascimentoUser")
    @org.jetbrains.annotations.NotNull
    private final java.util.Date dataNascimentoUser = null;
    @androidx.room.ColumnInfo(name = "cpfUser")
    @org.jetbrains.annotations.NotNull
    private final java.lang.String cpfUser = null;
    @androidx.room.ColumnInfo(name = "enderecoUser")
    @org.jetbrains.annotations.NotNull
    private final java.lang.String enderecoUser = null;
    @androidx.room.ColumnInfo(name = "cepUser")
    @org.jetbrains.annotations.NotNull
    private final java.lang.String cepUsuarioUser = null;
    @androidx.room.ColumnInfo(name = "telefoneUser")
    @org.jetbrains.annotations.NotNull
    private final java.lang.String telefoneUser = null;
    @androidx.room.ColumnInfo(name = "emailUser")
    @org.jetbrains.annotations.NotNull
    private final java.lang.String emailUser = null;
    @androidx.room.ColumnInfo(name = "numSusUser")
    @org.jetbrains.annotations.NotNull
    private final java.lang.String numSusUser = null;
    @androidx.room.ColumnInfo(name = "planoSaudeUser")
    @org.jetbrains.annotations.NotNull
    private final java.lang.String planoSaudeUser = null;
    @androidx.room.ColumnInfo(name = "numPlanoSaudeUser")
    @org.jetbrains.annotations.NotNull
    private final java.lang.String numPlanoSaudeUser = null;
    @androidx.room.ColumnInfo(name = "tipoSanguineoUser")
    @org.jetbrains.annotations.NotNull
    private final java.lang.String tipoSanguineoUser = null;
    
    public CadastroEntity(long idUser, @org.jetbrains.annotations.NotNull
    java.lang.String nomeUser, char sexoUser, @org.jetbrains.annotations.NotNull
    java.util.Date dataNascimentoUser, @org.jetbrains.annotations.NotNull
    java.lang.String cpfUser, @org.jetbrains.annotations.NotNull
    java.lang.String enderecoUser, @org.jetbrains.annotations.NotNull
    java.lang.String cepUsuarioUser, @org.jetbrains.annotations.NotNull
    java.lang.String telefoneUser, @org.jetbrains.annotations.NotNull
    java.lang.String emailUser, @org.jetbrains.annotations.NotNull
    java.lang.String numSusUser, @org.jetbrains.annotations.NotNull
    java.lang.String planoSaudeUser, @org.jetbrains.annotations.NotNull
    java.lang.String numPlanoSaudeUser, @org.jetbrains.annotations.NotNull
    java.lang.String tipoSanguineoUser) {
        super();
    }
    
    public final long getIdUser() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getNomeUser() {
        return null;
    }
    
    public final char getSexoUser() {
        return '\u0000';
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Date getDataNascimentoUser() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCpfUser() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getEnderecoUser() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCepUsuarioUser() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getTelefoneUser() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getEmailUser() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getNumSusUser() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getPlanoSaudeUser() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getNumPlanoSaudeUser() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getTipoSanguineoUser() {
        return null;
    }
    
    public final long component1() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component12() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component13() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component2() {
        return null;
    }
    
    public final char component3() {
        return '\u0000';
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Date component4() {
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
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.projetovital.data.db.entity.CadastroEntity copy(long idUser, @org.jetbrains.annotations.NotNull
    java.lang.String nomeUser, char sexoUser, @org.jetbrains.annotations.NotNull
    java.util.Date dataNascimentoUser, @org.jetbrains.annotations.NotNull
    java.lang.String cpfUser, @org.jetbrains.annotations.NotNull
    java.lang.String enderecoUser, @org.jetbrains.annotations.NotNull
    java.lang.String cepUsuarioUser, @org.jetbrains.annotations.NotNull
    java.lang.String telefoneUser, @org.jetbrains.annotations.NotNull
    java.lang.String emailUser, @org.jetbrains.annotations.NotNull
    java.lang.String numSusUser, @org.jetbrains.annotations.NotNull
    java.lang.String planoSaudeUser, @org.jetbrains.annotations.NotNull
    java.lang.String numPlanoSaudeUser, @org.jetbrains.annotations.NotNull
    java.lang.String tipoSanguineoUser) {
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