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
import com.example.projetovital.data.db.dao.CadastroDao;
import com.example.projetovital.data.db.dao.CadastroDao_Impl;
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

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `tblCadastro` (`idUser` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `nomeUser` TEXT NOT NULL, `sexoUser` INTEGER NOT NULL, `dataNascimentoUser` TEXT NOT NULL, `cpfUser` TEXT NOT NULL, `enderecoUser` TEXT NOT NULL, `cepUsuarioUser` TEXT NOT NULL, `telefoneUser` TEXT NOT NULL, `emailUser` TEXT NOT NULL, `numSusUser` TEXT NOT NULL, `planoSaudeUser` TEXT NOT NULL, `numPlanoSaudeUser` TEXT NOT NULL, `tipoSanguineoUser` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'b625bdbff2e7d33adaaa47ce6822323d')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `tblCadastro`");
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
        final HashMap<String, TableInfo.Column> _columnsTblCadastro = new HashMap<String, TableInfo.Column>(13);
        _columnsTblCadastro.put("idUser", new TableInfo.Column("idUser", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblCadastro.put("nomeUser", new TableInfo.Column("nomeUser", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblCadastro.put("sexoUser", new TableInfo.Column("sexoUser", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblCadastro.put("dataNascimentoUser", new TableInfo.Column("dataNascimentoUser", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblCadastro.put("cpfUser", new TableInfo.Column("cpfUser", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblCadastro.put("enderecoUser", new TableInfo.Column("enderecoUser", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblCadastro.put("cepUsuarioUser", new TableInfo.Column("cepUsuarioUser", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
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
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "b625bdbff2e7d33adaaa47ce6822323d", "aa6de61b62911cac0916a548cbcf4f67");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "tblCadastro");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `tblCadastro`");
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
}
