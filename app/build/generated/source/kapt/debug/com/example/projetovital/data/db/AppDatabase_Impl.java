package com.example.projetovital.data.db;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.example.projetovital.data.db.dao.AgendaDao;
import com.example.projetovital.data.db.dao.AgendaDao_Impl;
import com.example.projetovital.data.db.dao.AlergiaDao;
import com.example.projetovital.data.db.dao.AlergiaDao_Impl;
import com.example.projetovital.data.db.dao.CadastroDao;
import com.example.projetovital.data.db.dao.CadastroDao_Impl;
import com.example.projetovital.data.db.dao.ExamesDao;
import com.example.projetovital.data.db.dao.ExamesDao_Impl;
import com.example.projetovital.data.db.dao.MedicamentoDao;
import com.example.projetovital.data.db.dao.MedicamentoDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile CadastroDao _cadastroDao;

  private volatile AgendaDao _agendaDao;

  private volatile ExamesDao _examesDao;

  private volatile MedicamentoDao _medicamentoDao;

  private volatile AlergiaDao _alergiaDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `tblAgenda` (`idAgenda` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `especialidadeAgenda` TEXT NOT NULL, `dataAgenda` TEXT NOT NULL, `horaAgenda` TEXT NOT NULL, `localAgenda` TEXT NOT NULL, `procedimentoAgenda` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `tblAlergia` (`idAlergia` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `nomeAlergia` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `tblCadastro` (`idUser` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `nomeUser` TEXT NOT NULL, `sexoUser` INTEGER NOT NULL, `dataNascimentoUser` TEXT NOT NULL, `cpfUser` TEXT NOT NULL, `enderecoUser` TEXT NOT NULL, `cepUser` TEXT NOT NULL, `telefoneUser` TEXT NOT NULL, `emailUser` TEXT NOT NULL, `numSusUser` TEXT NOT NULL, `planoSaudeUser` TEXT NOT NULL, `numPlanoSaudeUser` TEXT NOT NULL, `tipoSanguineoUser` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `tblExames` (`idExame` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `especialidadeExame` TEXT NOT NULL, `dataExame` TEXT NOT NULL, `localExame` TEXT NOT NULL, `procedimentoExame` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `tblMedicamento` (`idMedicamento` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `nomeMedicamento` TEXT NOT NULL, `doseMedicamento` TEXT NOT NULL, `duracaoMedicamento` TEXT NOT NULL, `intervaloMedicamento` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'a7af5726e27c7329c1b45d6696a4bb93')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `tblAgenda`");
        db.execSQL("DROP TABLE IF EXISTS `tblAlergia`");
        db.execSQL("DROP TABLE IF EXISTS `tblCadastro`");
        db.execSQL("DROP TABLE IF EXISTS `tblExames`");
        db.execSQL("DROP TABLE IF EXISTS `tblMedicamento`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsTblAgenda = new HashMap<String, TableInfo.Column>(6);
        _columnsTblAgenda.put("idAgenda", new TableInfo.Column("idAgenda", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblAgenda.put("especialidadeAgenda", new TableInfo.Column("especialidadeAgenda", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblAgenda.put("dataAgenda", new TableInfo.Column("dataAgenda", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblAgenda.put("horaAgenda", new TableInfo.Column("horaAgenda", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblAgenda.put("localAgenda", new TableInfo.Column("localAgenda", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblAgenda.put("procedimentoAgenda", new TableInfo.Column("procedimentoAgenda", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTblAgenda = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTblAgenda = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTblAgenda = new TableInfo("tblAgenda", _columnsTblAgenda, _foreignKeysTblAgenda, _indicesTblAgenda);
        final TableInfo _existingTblAgenda = TableInfo.read(db, "tblAgenda");
        if (!_infoTblAgenda.equals(_existingTblAgenda)) {
          return new RoomOpenHelper.ValidationResult(false, "tblAgenda(com.example.projetovital.data.db.entity.AgendaEntity).\n"
                  + " Expected:\n" + _infoTblAgenda + "\n"
                  + " Found:\n" + _existingTblAgenda);
        }
        final HashMap<String, TableInfo.Column> _columnsTblAlergia = new HashMap<String, TableInfo.Column>(2);
        _columnsTblAlergia.put("idAlergia", new TableInfo.Column("idAlergia", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblAlergia.put("nomeAlergia", new TableInfo.Column("nomeAlergia", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTblAlergia = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTblAlergia = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTblAlergia = new TableInfo("tblAlergia", _columnsTblAlergia, _foreignKeysTblAlergia, _indicesTblAlergia);
        final TableInfo _existingTblAlergia = TableInfo.read(db, "tblAlergia");
        if (!_infoTblAlergia.equals(_existingTblAlergia)) {
          return new RoomOpenHelper.ValidationResult(false, "tblAlergia(com.example.projetovital.data.db.entity.AlergiaEntity).\n"
                  + " Expected:\n" + _infoTblAlergia + "\n"
                  + " Found:\n" + _existingTblAlergia);
        }
        final HashMap<String, TableInfo.Column> _columnsTblCadastro = new HashMap<String, TableInfo.Column>(13);
        _columnsTblCadastro.put("idUser", new TableInfo.Column("idUser", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblCadastro.put("nomeUser", new TableInfo.Column("nomeUser", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblCadastro.put("sexoUser", new TableInfo.Column("sexoUser", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblCadastro.put("dataNascimentoUser", new TableInfo.Column("dataNascimentoUser", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblCadastro.put("cpfUser", new TableInfo.Column("cpfUser", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblCadastro.put("enderecoUser", new TableInfo.Column("enderecoUser", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblCadastro.put("cepUser", new TableInfo.Column("cepUser", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblCadastro.put("telefoneUser", new TableInfo.Column("telefoneUser", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblCadastro.put("emailUser", new TableInfo.Column("emailUser", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblCadastro.put("numSusUser", new TableInfo.Column("numSusUser", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblCadastro.put("planoSaudeUser", new TableInfo.Column("planoSaudeUser", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblCadastro.put("numPlanoSaudeUser", new TableInfo.Column("numPlanoSaudeUser", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblCadastro.put("tipoSanguineoUser", new TableInfo.Column("tipoSanguineoUser", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTblCadastro = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTblCadastro = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTblCadastro = new TableInfo("tblCadastro", _columnsTblCadastro, _foreignKeysTblCadastro, _indicesTblCadastro);
        final TableInfo _existingTblCadastro = TableInfo.read(db, "tblCadastro");
        if (!_infoTblCadastro.equals(_existingTblCadastro)) {
          return new RoomOpenHelper.ValidationResult(false, "tblCadastro(com.example.projetovital.data.db.entity.CadastroEntity).\n"
                  + " Expected:\n" + _infoTblCadastro + "\n"
                  + " Found:\n" + _existingTblCadastro);
        }
        final HashMap<String, TableInfo.Column> _columnsTblExames = new HashMap<String, TableInfo.Column>(5);
        _columnsTblExames.put("idExame", new TableInfo.Column("idExame", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblExames.put("especialidadeExame", new TableInfo.Column("especialidadeExame", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblExames.put("dataExame", new TableInfo.Column("dataExame", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblExames.put("localExame", new TableInfo.Column("localExame", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblExames.put("procedimentoExame", new TableInfo.Column("procedimentoExame", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTblExames = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTblExames = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTblExames = new TableInfo("tblExames", _columnsTblExames, _foreignKeysTblExames, _indicesTblExames);
        final TableInfo _existingTblExames = TableInfo.read(db, "tblExames");
        if (!_infoTblExames.equals(_existingTblExames)) {
          return new RoomOpenHelper.ValidationResult(false, "tblExames(com.example.projetovital.data.db.entity.ExamesEntity).\n"
                  + " Expected:\n" + _infoTblExames + "\n"
                  + " Found:\n" + _existingTblExames);
        }
        final HashMap<String, TableInfo.Column> _columnsTblMedicamento = new HashMap<String, TableInfo.Column>(5);
        _columnsTblMedicamento.put("idMedicamento", new TableInfo.Column("idMedicamento", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblMedicamento.put("nomeMedicamento", new TableInfo.Column("nomeMedicamento", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblMedicamento.put("doseMedicamento", new TableInfo.Column("doseMedicamento", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblMedicamento.put("duracaoMedicamento", new TableInfo.Column("duracaoMedicamento", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblMedicamento.put("intervaloMedicamento", new TableInfo.Column("intervaloMedicamento", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTblMedicamento = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTblMedicamento = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTblMedicamento = new TableInfo("tblMedicamento", _columnsTblMedicamento, _foreignKeysTblMedicamento, _indicesTblMedicamento);
        final TableInfo _existingTblMedicamento = TableInfo.read(db, "tblMedicamento");
        if (!_infoTblMedicamento.equals(_existingTblMedicamento)) {
          return new RoomOpenHelper.ValidationResult(false, "tblMedicamento(com.example.projetovital.data.db.entity.MedicamentoEntity).\n"
                  + " Expected:\n" + _infoTblMedicamento + "\n"
                  + " Found:\n" + _existingTblMedicamento);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "a7af5726e27c7329c1b45d6696a4bb93", "674d51d5afc3624ba05c1bae8dee4ea7");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "tblAgenda","tblAlergia","tblCadastro","tblExames","tblMedicamento");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `tblAgenda`");
      _db.execSQL("DELETE FROM `tblAlergia`");
      _db.execSQL("DELETE FROM `tblCadastro`");
      _db.execSQL("DELETE FROM `tblExames`");
      _db.execSQL("DELETE FROM `tblMedicamento`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(CadastroDao.class, CadastroDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(AgendaDao.class, AgendaDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ExamesDao.class, ExamesDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(MedicamentoDao.class, MedicamentoDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(AlergiaDao.class, AlergiaDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public CadastroDao cadastroDao() {
    if (_cadastroDao != null) {
      return _cadastroDao;
    } else {
      synchronized(this) {
        if(_cadastroDao == null) {
          _cadastroDao = new CadastroDao_Impl(this);
        }
        return _cadastroDao;
      }
    }
  }

  @Override
  public AgendaDao agendaDao() {
    if (_agendaDao != null) {
      return _agendaDao;
    } else {
      synchronized(this) {
        if(_agendaDao == null) {
          _agendaDao = new AgendaDao_Impl(this);
        }
        return _agendaDao;
      }
    }
  }

  @Override
  public ExamesDao examesDao() {
    if (_examesDao != null) {
      return _examesDao;
    } else {
      synchronized(this) {
        if(_examesDao == null) {
          _examesDao = new ExamesDao_Impl(this);
        }
        return _examesDao;
      }
    }
  }

  @Override
  public MedicamentoDao medicamentoDao() {
    if (_medicamentoDao != null) {
      return _medicamentoDao;
    } else {
      synchronized(this) {
        if(_medicamentoDao == null) {
          _medicamentoDao = new MedicamentoDao_Impl(this);
        }
        return _medicamentoDao;
      }
    }
  }

  @Override
  public AlergiaDao alergiaDao() {
    if (_alergiaDao != null) {
      return _alergiaDao;
    } else {
      synchronized(this) {
        if(_alergiaDao == null) {
          _alergiaDao = new AlergiaDao_Impl(this);
        }
        return _alergiaDao;
      }
    }
  }
}
