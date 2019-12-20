package com.medicaApp.service.impl;

import com.medicaApp.model.ResetToken;

public interface IResetTokenService {
	
	void guardar(ResetToken token);
	void eliminar(ResetToken token);
	ResetToken findByToken(String userName);

}
