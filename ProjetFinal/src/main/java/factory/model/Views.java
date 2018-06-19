package factory.model;

public class Views {

	public static class ViewCommon {

	}

	public static class ViewFormation extends ViewCommon {

	}

	public static class ViewFormateur extends ViewCommon {

	}

	public static class ViewMatiere extends ViewCommon {

	}

	public static class ViewGestionnaire extends ViewCommon {

	}

	public static class ViewVideoProjecteur extends ViewCommon {

	}

	public static class ViewOrdinateur extends ViewCommon {

	}

	public static class ViewModule extends ViewCommon {

	}

	public static class ViewTechnicien extends ViewCommon {

	}

	public static class ViewSalle extends ViewCommon {

	}

	public static class ViewSalleWithModule extends ViewSalle {

	}
	
	public static class ViewGestionnaireWithFormations extends ViewGestionnaire {

	}

	public static class ViewFormationWithStagiaires extends ViewFormation {

	}

	
	public static class ViewFormationWithGestionnaire extends ViewFormation {
		
	}
	

	public static class ViewOrdinateurWithStagiaires extends ViewOrdinateur {

	}

	public static class ViewFormateurWithFormations extends ViewFormateur {

	}

	public static class ViewFormateurWithModules extends ViewFormateur {
		
	}
	

	public static class ViewMatiereWithModules extends ViewMatiere {

	}

	public static class ViewFormationWithModules extends ViewFormation {

	}

	public static class ViewStagiaire extends ViewCommon {

	}

	public static class ViewStagiaireWithOrdinateurs extends ViewStagiaire {

	}

}
