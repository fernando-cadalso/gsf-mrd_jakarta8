package local.fmc.gsf.mrd.bean;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;

public enum TipoSeveridade {

	INFO {
		protected Severity tipo() {
			return FacesMessage.SEVERITY_INFO;
		}
	},
	AVISO {
		protected Severity tipo() {
			return FacesMessage.SEVERITY_WARN;
		}
	},
	ERRO {
		protected Severity tipo() {
			return FacesMessage.SEVERITY_ERROR;
		}
	};

	protected abstract Severity tipo();
}
