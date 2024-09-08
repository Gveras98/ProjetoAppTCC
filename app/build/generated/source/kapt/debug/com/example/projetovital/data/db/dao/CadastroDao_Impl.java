package com.example.projetovital.data.db.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.projetovital.data.db.DateConverter;
import com.example.projetovital.data.db.entity.CadastroEntity;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class CadastroDao_Impl implements CadastroDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<CadastroEntity> __insertionAdapterOfCadastroEntity;

  private final DateConverter __dateConverter = new DateConverter();

  private final EntityDeletionOrUpdateAdapter<CadastroEntity> __updateAdapterOfCadastroEntity;

  public CadastroDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCadastroEntity = new EntityInsertionAdapter<CadastroEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `tblCadastro` (`idUser`,`nomeUser`,`sexoUser`,`dataNascimentoUser`,`cpfUser`,`enderecoUser`,`cepUsuarioUser`,`telefoneUser`,`emailUser`,`numSusUser`,`planoSaudeUser`,`numPlanoSaudeUser`,`tipoSanguineoUser`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final CadastroEntity entity) {
        statement.bindLong(1, entity.getIdUser());
        if (entity.getNomeUser() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getNomeUser());
        }
        statement.bindLong(3, entity.getSexoUser());
        final String _tmp = __dateConverter.fromDate(entity.getDataNascimentoUser());
        if (_tmp == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, _tmp);
        }
        if (entity.getCpfUser() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getCpfUser());
        }
        if (entity.getEnderecoUser() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getEnderecoUser());
        }
        if (entity.getCepUsuarioUser() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getCepUsuarioUser());
        }
        if (entity.getTelefoneUser() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getTelefoneUser());
        }
        if (entity.getEmailUser() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getEmailUser());
        }
        if (entity.getNumSusUser() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getNumSusUser());
        }
        if (entity.getPlanoSaudeUser() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getPlanoSaudeUser());
        }
        if (entity.getNumPlanoSaudeUser() == null) {
          statement.bindNull(12);
        } else {
          statement.bindString(12, entity.getNumPlanoSaudeUser());
        }
        if (entity.getTipoSanguineoUser() == null) {
          statement.bindNull(13);
        } else {
          statement.bindString(13, entity.getTipoSanguineoUser());
        }
      }
    };
    this.__updateAdapterOfCadastroEntity = new EntityDeletionOrUpdateAdapter<CadastroEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `tblCadastro` SET `idUser` = ?,`nomeUser` = ?,`sexoUser` = ?,`dataNascimentoUser` = ?,`cpfUser` = ?,`enderecoUser` = ?,`cepUsuarioUser` = ?,`telefoneUser` = ?,`emailUser` = ?,`numSusUser` = ?,`planoSaudeUser` = ?,`numPlanoSaudeUser` = ?,`tipoSanguineoUser` = ? WHERE `idUser` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final CadastroEntity entity) {
        statement.bindLong(1, entity.getIdUser());
        if (entity.getNomeUser() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getNomeUser());
        }
        statement.bindLong(3, entity.getSexoUser());
        final String _tmp = __dateConverter.fromDate(entity.getDataNascimentoUser());
        if (_tmp == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, _tmp);
        }
        if (entity.getCpfUser() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getCpfUser());
        }
        if (entity.getEnderecoUser() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getEnderecoUser());
        }
        if (entity.getCepUsuarioUser() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getCepUsuarioUser());
        }
        if (entity.getTelefoneUser() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getTelefoneUser());
        }
        if (entity.getEmailUser() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getEmailUser());
        }
        if (entity.getNumSusUser() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getNumSusUser());
        }
        if (entity.getPlanoSaudeUser() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getPlanoSaudeUser());
        }
        if (entity.getNumPlanoSaudeUser() == null) {
          statement.bindNull(12);
        } else {
          statement.bindString(12, entity.getNumPlanoSaudeUser());
        }
        if (entity.getTipoSanguineoUser() == null) {
          statement.bindNull(13);
        } else {
          statement.bindString(13, entity.getTipoSanguineoUser());
        }
        statement.bindLong(14, entity.getIdUser());
      }
    };
  }

  @Override
  public Object insert(final CadastroEntity cadastro,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfCadastroEntity.insert(cadastro);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object update(final CadastroEntity cadastro,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfCadastroEntity.handle(cadastro);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public LiveData<List<CadastroEntity>> getAll() {
    final String _sql = "SELECT * FROM tblCadastro";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"tblCadastro"}, false, new Callable<List<CadastroEntity>>() {
      @Override
      @Nullable
      public List<CadastroEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfIdUser = CursorUtil.getColumnIndexOrThrow(_cursor, "idUser");
          final int _cursorIndexOfNomeUser = CursorUtil.getColumnIndexOrThrow(_cursor, "nomeUser");
          final int _cursorIndexOfSexoUser = CursorUtil.getColumnIndexOrThrow(_cursor, "sexoUser");
          final int _cursorIndexOfDataNascimentoUser = CursorUtil.getColumnIndexOrThrow(_cursor, "dataNascimentoUser");
          final int _cursorIndexOfCpfUser = CursorUtil.getColumnIndexOrThrow(_cursor, "cpfUser");
          final int _cursorIndexOfEnderecoUser = CursorUtil.getColumnIndexOrThrow(_cursor, "enderecoUser");
          final int _cursorIndexOfCepUsuarioUser = CursorUtil.getColumnIndexOrThrow(_cursor, "cepUsuarioUser");
          final int _cursorIndexOfTelefoneUser = CursorUtil.getColumnIndexOrThrow(_cursor, "telefoneUser");
          final int _cursorIndexOfEmailUser = CursorUtil.getColumnIndexOrThrow(_cursor, "emailUser");
          final int _cursorIndexOfNumSusUser = CursorUtil.getColumnIndexOrThrow(_cursor, "numSusUser");
          final int _cursorIndexOfPlanoSaudeUser = CursorUtil.getColumnIndexOrThrow(_cursor, "planoSaudeUser");
          final int _cursorIndexOfNumPlanoSaudeUser = CursorUtil.getColumnIndexOrThrow(_cursor, "numPlanoSaudeUser");
          final int _cursorIndexOfTipoSanguineoUser = CursorUtil.getColumnIndexOrThrow(_cursor, "tipoSanguineoUser");
          final List<CadastroEntity> _result = new ArrayList<CadastroEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final CadastroEntity _item;
            final long _tmpIdUser;
            _tmpIdUser = _cursor.getLong(_cursorIndexOfIdUser);
            final String _tmpNomeUser;
            if (_cursor.isNull(_cursorIndexOfNomeUser)) {
              _tmpNomeUser = null;
            } else {
              _tmpNomeUser = _cursor.getString(_cursorIndexOfNomeUser);
            }
            final char _tmpSexoUser;
            _tmpSexoUser = (char) (_cursor.getInt(_cursorIndexOfSexoUser));
            final Date _tmpDataNascimentoUser;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfDataNascimentoUser)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfDataNascimentoUser);
            }
            _tmpDataNascimentoUser = __dateConverter.toDate(_tmp);
            final String _tmpCpfUser;
            if (_cursor.isNull(_cursorIndexOfCpfUser)) {
              _tmpCpfUser = null;
            } else {
              _tmpCpfUser = _cursor.getString(_cursorIndexOfCpfUser);
            }
            final String _tmpEnderecoUser;
            if (_cursor.isNull(_cursorIndexOfEnderecoUser)) {
              _tmpEnderecoUser = null;
            } else {
              _tmpEnderecoUser = _cursor.getString(_cursorIndexOfEnderecoUser);
            }
            final String _tmpCepUsuarioUser;
            if (_cursor.isNull(_cursorIndexOfCepUsuarioUser)) {
              _tmpCepUsuarioUser = null;
            } else {
              _tmpCepUsuarioUser = _cursor.getString(_cursorIndexOfCepUsuarioUser);
            }
            final String _tmpTelefoneUser;
            if (_cursor.isNull(_cursorIndexOfTelefoneUser)) {
              _tmpTelefoneUser = null;
            } else {
              _tmpTelefoneUser = _cursor.getString(_cursorIndexOfTelefoneUser);
            }
            final String _tmpEmailUser;
            if (_cursor.isNull(_cursorIndexOfEmailUser)) {
              _tmpEmailUser = null;
            } else {
              _tmpEmailUser = _cursor.getString(_cursorIndexOfEmailUser);
            }
            final String _tmpNumSusUser;
            if (_cursor.isNull(_cursorIndexOfNumSusUser)) {
              _tmpNumSusUser = null;
            } else {
              _tmpNumSusUser = _cursor.getString(_cursorIndexOfNumSusUser);
            }
            final String _tmpPlanoSaudeUser;
            if (_cursor.isNull(_cursorIndexOfPlanoSaudeUser)) {
              _tmpPlanoSaudeUser = null;
            } else {
              _tmpPlanoSaudeUser = _cursor.getString(_cursorIndexOfPlanoSaudeUser);
            }
            final String _tmpNumPlanoSaudeUser;
            if (_cursor.isNull(_cursorIndexOfNumPlanoSaudeUser)) {
              _tmpNumPlanoSaudeUser = null;
            } else {
              _tmpNumPlanoSaudeUser = _cursor.getString(_cursorIndexOfNumPlanoSaudeUser);
            }
            final String _tmpTipoSanguineoUser;
            if (_cursor.isNull(_cursorIndexOfTipoSanguineoUser)) {
              _tmpTipoSanguineoUser = null;
            } else {
              _tmpTipoSanguineoUser = _cursor.getString(_cursorIndexOfTipoSanguineoUser);
            }
            _item = new CadastroEntity(_tmpIdUser,_tmpNomeUser,_tmpSexoUser,_tmpDataNascimentoUser,_tmpCpfUser,_tmpEnderecoUser,_tmpCepUsuarioUser,_tmpTelefoneUser,_tmpEmailUser,_tmpNumSusUser,_tmpPlanoSaudeUser,_tmpNumPlanoSaudeUser,_tmpTipoSanguineoUser);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
