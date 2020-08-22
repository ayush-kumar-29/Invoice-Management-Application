# TODO: A utility class which will be created by the user , with Class name as " _[your roll number]" ,
# TODO: all transformations should be written inside a function which will be called inside the predict method


class _1705129():

    # TODO: Please note that document id should be present till the getPredictions method
    def __tranformation1(self, data):
        encoder = {'ABES3': 0, 'ABes3': 1, 'AT&T7': 2, 'CZRP4': 3, 'Cyon4': 4, 'ERes3': 5, 'EVRP3': 6, 'Faes6': 7, 'HYON10': 8, 'LERP4': 9, 'OMS 1': 10, 'PAES6': 11, 'Paks10': 12, 'Piat8': 13, 'Pres3': 14, 'RUMS10': 15, 'Sod 8': 16, 'Soon9': 17, 'Tyon1': 18, 'UMRP2': 19, 'VECS2': 20, 'Vees4': 21, 'WORT6': 22, 'Werp6': 23, 'ares6': 24, 'avto3': 25, 'body5': 26,
                   'chet3': 27, 'coeU2': 28, 'cvrp1': 29, 'deer10': 30, 'enme9': 31, 'gatd6': 32, 'holi10': 33, 'hoyz8': 34, 'jons3': 35, 'karp8': 36, 'mdtd4': 37, 'mech7': 38, 'meon6': 39, 'minc10': 40, 'nuus8': 41, 'oprp7': 42, 'pier9': 43, 'raad5': 44, 'raal9': 45, 'saer1': 46, 'seod1': 47, 'skes8': 48, 'syps7': 49, 'wart8': 50, 'wtds4': 51, 'xyes4': 52}
        data["business_code"] = encoder.get("business_code", 0)
        return data

    def __transformation2(self, data):

        # your transformation logic goes here
        return data

    def getPredictions(self, data, model):
        data = self.__tranformation1(data)
        data = self.__transformation2(data)

        # your feature list, column names business_code	cust_payment_terms 	actual_outstanding_amount     age_invoice
        features = ["cust_payment_terms","actual_outstanding_amount", "age_invoice"]
        print(data[features])
        # data should be a dataFrame and not a numpy array

        predictions = model.predict(data[features])
        data['predictions'] = predictions
        pred = data.loc[:, ["pk_id", 'actual_outstanding_amount','predictions']].to_dict(orient="records")
        return pred
